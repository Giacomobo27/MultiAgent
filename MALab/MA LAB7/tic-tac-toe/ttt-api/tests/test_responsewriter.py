
import unittest
from responsewriter import ResponseWriter
import json
from rdflib import Graph, URIRef, Namespace, RDF, Literal
from rdflib.namespace import NamespaceManager

from rdfstore import RDFStore

# Many (ok most) of these aren't proper tests because they just print the response to the console
# HOWEVER that's ok because this is all covered in end to end testing (in test_app.py) anyway
class TestResponseWriter(unittest.TestCase):

    apiBot = URIRef("http://localhost:8083/apibot")
    agentZero = URIRef("http://localhost:7070/agentzero")
    tttgame = URIRef("http://localhost:8083/game/id=1")
    
    def setUp(self):
        
        # Setup 
        g = Graph()
        g.parse('TicTacToe.owl')
        self.helper = RDFStore(g,'tic-tac-toe',self.tttgame, self.apiBot, self.agentZero, Literal("someId"))
        self.helper.add_move(self.helper.ttt.Square13, self.apiBot)
        self.helper.add_move(self.helper.ttt.Square12, self.agentZero)
        self.helper.add_move(self.helper.ttt.Square11, self.apiBot)


    # Test - basic
    def test_basic(self):
        print("TEST BASIC")
        rw = ResponseWriter("http://localhost:8083","ttt:Game")
        b = rw.build()
        
        # Test have "@id":"http://localhost:8083"
        # Test have "@type":"tttGame"
        self.assertEqual(b["@type"], "ttt:Game")
        self.assertEqual(b["@id"], "http://localhost:8083")
        # Test have 
        #    "@context": {
        #           "@vocab": "https://www.w3.org/2019/wot/hypermedia#",
        #           "ttt": "http://localhost:8083/tic-tac-toe#",
        #           "htv": "http://www.w3.org/2011/http#",
        #           "wot": "https://w3c.github.io/wot-thing-description/#",
        #           "sch": "https://schema.org/",
        #           "links": {
        #               "@id": "Link"
        #           },
        #           "forms": {
        #             "@id": "Form"
        #           },
        #           "href": {
        #             "@id": "hasTarget"
        #           },
        #           "rel": {
        #             "@type": "@vocab"
        #             "@id": "hasRelationType",
        #           }
        #       }
        context_json = b["@context"]
        self.assertEqual(context_json["@vocab"], "https://www.w3.org/2019/wot/hypermedia#")
        self.assertEqual(context_json["ttt"],  "http://localhost:8083/tic-tac-toe#")
        self.assertEqual(context_json["htv"], "http://www.w3.org/2011/http#")
        self.assertEqual(context_json["wot"], "https://w3c.github.io/wot-thing-description/#")
        self.assertEqual(context_json["sch"], "https://schema.org/")

    # Test - index page, not registered (link to register form)
    def test_index_page(self):
        print("TEST INDEX PAGE NOT REGISTERED")
        rw = ResponseWriter("http://localhost:8083","ttt:Game")
        rw.add_link("http://localhost:8083/tic-tac-toe",method_name="GET")
        rw.add_link("http://localhost:8083/apibot",method_name="GET")
        rw.add_link("http://localhost:8083/register",method_name="GET")
        rw.add_form("http://localhost:8083/register",method_name="POST",contentType="application/json",op="writeproperty")
        b = rw.build()

         # Test have "@id":"http://localhost:8083"
        # Test have "@type":"tttGame"
        self.assertEqual(b["@type"], "ttt:Game")
        self.assertEqual(b["@id"], "http://localhost:8083")
        # Test have 
        #    "@context": {
        #           "@vocab": "https://www.w3.org/2019/wot/hypermedia#",
        #           "ttt": "http://localhost:8083/tic-tac-toe#",
        #           "htv": "http://www.w3.org/2011/http#",
        #           "wot": "https://w3c.github.io/wot-thing-description/#",
        #           "sch": "https://schema.org/",
        #           "links": {
        #               "@id": "Link"
        #           },
        #           "forms": {
        #             "@id": "Form"
        #           },
        #           "href": {
        #             "@id": "hasTarget"
        #           },
        #           "rel": {
        #             "@type": "@vocab"
        #             "@id": "hasRelationType",
        #           }
        #       }
        context_json = b["@context"]
        self.assertEqual(context_json["@vocab"], "https://www.w3.org/2019/wot/hypermedia#")
        self.assertEqual(context_json["ttt"],  "http://localhost:8083/tic-tac-toe#")
        self.assertEqual(context_json["htv"], "http://www.w3.org/2011/http#")
        self.assertEqual(context_json["wot"], "https://w3c.github.io/wot-thing-description/#")
        self.assertEqual(context_json["sch"], "https://schema.org/")
        print(json.dumps(b, indent=4))


    # Test - index page, registered
    def test_index_page_registered(self):
        print("TEST INDEX PAGE REGISTERED")
        rw = ResponseWriter("http://localhost:8083/","ttt:Game")
        rw.add_field("ttt:Game",{"ttt:hasID":self.helper.id})
        rw.add_link("http://localhost:8083/tic-tac-toe",method_name="GET")
        rw.add_link("http://localhost:8083/apibot",method_name="GET")
        rw.add_link("http://localhost:8083/register",method_name="GET")
        rw.add_link("http://localhost:8083/result",method_name="GET")
        rw.add_link("http://localhost:8083/board",method_name="GET")
        rw.add_form("http://localhost:8083/square",method_name="POST",contentType="application/json",op="writeproperty")
        b = rw.build()
        print(json.dumps(b, indent=4))
    

    # Test - apibot page (includes information in JSON)
    def test_apibot_page(self):
        print("TEST API BOT")
        rw = ResponseWriter("http://localhost:8083/apibot","ttt:Agent")
        rw.add_field("description","basic opponent (no strategy)")
        rw.add_link("http://localhost:8083/index",method_name="GET")
        b = rw.build()
        print(json.dumps(b, indent=4))
    

    # Test - result response TODO think about this in ontology
    def test_result_page(self):
        print("TEST RESULT PAGE")
        rw = ResponseWriter("http://localhost:8083/result","ttt:TicTacToeResult")
        rw.add_field("ttt:TicTacToeResult","ttt:XPlayerRole")
        rw.add_link("http://localhost:8083/index",method_name="GET")
        b = rw.build()
        print(json.dumps(b, indent=4))
    
    
    # Test - result page, not registered
    def test_result_page_not_registered(self):
        print("TEST PAGE NOT REGISTRED")
        rw = ResponseWriter("http://localhost:8083/result","ttt:TicTacToeResult")
        rw.add_error("Not registered")
        rw.add_link("http://localhost:8083/index",method_name="GET")
        b = rw.build()
        print(json.dumps(b, indent=4))
    

    # Test - board response
    def test_board_page(self):
        print("TEST BOARD PAGE")
        rw = ResponseWriter("http://localhost:8083/board","ttt:Board")
        
        #TODO: add keyword in ontology for board to group this better
        # apprieviate full url of squares to ttt:
        board = self.helper.get_board_occupied()
        for b in board:
            
            rw.add_field(b,board[b])
        
        
        rw.add_link("http://localhost:8083/index",method_name="GET")
        b = rw.build()
        print(json.dumps(b, indent=4))


    def test_form(self):
        print("TEST FORM")
        rw = ResponseWriter("http://localhost:8083/register","ttt:Game")
        rw.add_form("http://localhost:8083/register",method_name="POST",contentType="application/json",op="writeproperty")
        rw.add_form_property("http://localhost:8083/register","ttt:Agent",False,True)
        b = rw.build()
        print(json.dumps(b, indent=4))
    # Test - square form response

    # Test - square response
