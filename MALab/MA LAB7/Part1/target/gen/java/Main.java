/**
 * GENERATED CODE - DO NOT CHANGE
 */

import astra.core.*;
import astra.execution.*;
import astra.event.*;
import astra.messaging.*;
import astra.formula.*;
import astra.lang.*;
import astra.statement.*;
import astra.term.*;
import astra.type.*;
import astra.tr.*;
import astra.reasoner.util.*;

import mams.web.HttpResponse;
import mams.JSONConverter;
import mams.JSONBuilder;
import astra.jena.*;
import com.fasterxml.jackson.databind.JsonNode;

public class Main extends ASTRAClass {
	public Main() {
		setParents(new Class[] {Shared.class});
		addRule(new Rule(
			"Main", new int[] {21,9,21,58},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "l",false)
					})
				)
			),
			new Predicate("api_index_url", new Term[] {
				new Variable(Type.STRING, "game_url",false)
			}),
			new Block(
				"Main", new int[] {21,57,35,5},
				new Statement[] {
					new ModuleCall("messaging",
						"Main", new int[] {23,8,23,77},
						new Predicate("installService", new Term[] {
							Primitive.newPrimitive("mams"),
							Primitive.newPrimitive("mams.messaging.MAMSMessageService")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Messaging) intention.getModule("Main","messaging")).installService(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ScopedSubgoal(
						"Main", new int[] {25,8,35,5},
						"MAMSAgent",
						new Goal(
							new Predicate("setup", new Term[] {})
						)
					),
					new ScopedSubgoal(
						"Main", new int[] {26,8,35,5},
						"MAMSAgent",
						new Goal(
							new Predicate("created", new Term[] {
								Primitive.newPrimitive("base")
							})
						)
					),
					new ScopedSubgoal(
						"Main", new int[] {27,8,35,5},
						"IntegratedInbox",
						new Goal(
							new Predicate("created", new Term[] {
								Primitive.newPrimitive("inbox")
							})
						)
					),
					new ModuleCall("system",
						"Main", new int[] {29,8,29,49},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("AgentZero"),
							Primitive.newPrimitive("Player")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Main","system")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("system",
						"Main", new int[] {30,8,30,51},
						new Predicate("setMainGoal", new Term[] {
							Primitive.newPrimitive("AgentZero"),
							new ListTerm(new Term[] {
								new Variable(Type.STRING, "game_url")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Main","system")).setMainGoal(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("system",
						"Main", new int[] {32,8,32,25},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(2000)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Main","system")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Main", new int[] {34,8,35,5},
						new Goal(
							new Predicate("game", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {37,9,37,52},
			new GoalEvent('+',
				new Goal(
					new Predicate("game", new Term[] {})
				)
			),
			new Predicate("api_index_url", new Term[] {
				new Variable(Type.STRING, "game_url",false)
			}),
			new Block(
				"Main", new int[] {37,51,39,5},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {41,9,41,78},
			new ModuleEvent("knowledgeStore",
				"$re",
				new Predicate("read", new Term[] {
					new Variable(Type.STRING, "url",false)
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.jena.KnowledgeStore) agent.getModule("Main","knowledgeStore")).read(
							predicate.getTerm(0)
						);
					}
				}
			),
			new ModuleFormula("strings",
				new Predicate("endsWith", new Term[] {
					new Variable(Type.STRING, "url"),
					Primitive.newPrimitive("players")
				}),
			new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).endsWith(
							(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
							(java.lang.String) visitor.evaluate(predicate.getTerm(1))
						);
				}
			}
				),
			new Block(
				"Main", new int[] {41,77,43,5},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {45,9,45,129},
			new BeliefEvent('+',
				new Predicate("form_actions", new Term[] {
					new Variable(Type.STRING, "form_url",false),
					new Variable(Type.STRING, "http_method",false),
					new Variable(Type.LIST, "required_actions",false)
				})
			),
			new ModuleFormula("strings",
				new Predicate("endsWith", new Term[] {
					new Variable(Type.STRING, "form_url"),
					Primitive.newPrimitive("registerGame")
				}),
			new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).endsWith(
							(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
							(java.lang.String) visitor.evaluate(predicate.getTerm(1))
						);
				}
			}
				),
			new Block(
				"Main", new int[] {45,128,47,5},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {49,9,49,83},
			new ModuleEvent("knowledgeStore",
				"$re",
				new Predicate("read", new Term[] {
					new Variable(Type.STRING, "url",false)
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.jena.KnowledgeStore) agent.getModule("Main","knowledgeStore")).read(
							predicate.getTerm(0)
						);
					}
				}
			),
			new ModuleFormula("strings",
				new Predicate("endsWith", new Term[] {
					new Variable(Type.STRING, "url"),
					Primitive.newPrimitive("registerGame")
				}),
			new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).endsWith(
							(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
							(java.lang.String) visitor.evaluate(predicate.getTerm(1))
						);
				}
			}
				),
			new Block(
				"Main", new int[] {49,82,51,5},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {60,10,60,31},
			new GoalEvent('+',
				new Goal(
					new Predicate("clear_knowledge", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {60,30,69,5},
				new Statement[] {
					new ModuleCall("knowledgeStore",
						"Main", new int[] {61,8,61,30},
						new Predicate("clear", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.jena.KnowledgeStore) intention.getModule("Main","knowledgeStore")).clear(
								);
							}
						}
					),
					new ForEach(
						"Main", new int[] {63,8,69,5},
						new Predicate("form_actions", new Term[] {
							new Variable(Type.STRING, "anyForm",false),
							new Variable(Type.STRING, "method_name",false),
							new Variable(Type.LIST, "any_list",false)
						}),
						new Block(
							"Main", new int[] {63,81,65,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Main", new int[] {64,12,65,9},
									new Predicate("form_actions", new Term[] {
										new Variable(Type.STRING, "anyForm"),
										new Variable(Type.STRING, "method_name"),
										new Variable(Type.LIST, "any_list")
									})
								)
							}
						)
					),
					new ForEach(
						"Main", new int[] {66,8,69,5},
						new Predicate("link_actions", new Term[] {
							new Variable(Type.STRING, "anyLink",false)
						}),
						new Block(
							"Main", new int[] {66,46,68,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Main", new int[] {67,12,68,9},
									new Predicate("link_actions", new Term[] {
										new Variable(Type.STRING, "anyLink")
									})
								)
							}
						)
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("api_index_url", new Term[] {
				Primitive.newPrimitive("http://localhost:8083/")
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("knowledgeStore",astra.jena.KnowledgeStore.class,agent);
		return fragment;
	}

	public static void main(String[] args) {
		Scheduler.setStrategy(new TestSchedulerStrategy());
		ListTerm argList = new ListTerm();
		for (String arg: args) {
			argList.add(Primitive.newPrimitive(arg));
		}

		String name = java.lang.System.getProperty("astra.name", "main");
		try {
			astra.core.Agent agent = new Main().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: Main");
			}
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
