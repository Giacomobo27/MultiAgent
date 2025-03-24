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

public class Player extends ASTRAClass {
	public Player() {
		setParents(new Class[] {Shared.class});
		addRule(new Rule(
			"Player", new int[] {26,9,26,31},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new ListTerm(new Term[] {
							new Variable(Type.STRING, "url",false)
						})
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {26,30,47,5},
				new Statement[] {
					new BeliefUpdate('+',
						"Player", new int[] {28,8,47,5},
						new Predicate("api_index_url", new Term[] {
							new Variable(Type.STRING, "url")
						})
					),
					new ScopedSubgoal(
						"Player", new int[] {31,8,47,5},
						"MAMSAgent",
						new Goal(
							new Predicate("init", new Term[] {})
						)
					),
					new ScopedSubgoal(
						"Player", new int[] {32,8,47,5},
						"MAMSAgent",
						new Goal(
							new Predicate("created", new Term[] {
								Primitive.newPrimitive("base")
							})
						)
					),
					new ScopedSubgoal(
						"Player", new int[] {33,8,47,5},
						"IntegratedInbox",
						new Goal(
							new Predicate("created", new Term[] {
								Primitive.newPrimitive("inbox")
							})
						)
					),
					new Subgoal(
						"Player", new int[] {36,8,47,5},
						new Goal(
							new Predicate("itemProperty", new Term[] {
								Primitive.newPrimitive("base"),
								Primitive.newPrimitive("uri"),
								new Variable(Type.FUNCTION, "agentUri",false)
							})
						)
					),
					new Declaration(
						new Variable(Type.STRING, "uri"),
						"Player", new int[] {37,8,47,5},
						new ModuleTerm("F", Type.STRING,
							new Predicate("valueAsString", new Term[] {
								new Variable(Type.FUNCTION, "agentUri"),
								Primitive.newPrimitive(0)
							}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.Functions) intention.getModule("Player","F")).valueAsString(
										(astra.term.Funct) intention.evaluate(predicate.getTerm(0)),
										(int) intention.evaluate(predicate.getTerm(1))
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.Functions) visitor.agent().getModule("Player","F")).valueAsString(
										(astra.term.Funct) visitor.evaluate(predicate.getTerm(0)),
										(int) visitor.evaluate(predicate.getTerm(1))
									);
								}
							}
						)
					),
					new BeliefUpdate('+',
						"Player", new int[] {39,8,47,5},
						new Predicate("agent_attributes", new Term[] {
							Primitive.newPrimitive("@id"),
							new Variable(Type.STRING, "uri")
						})
					),
					new BeliefUpdate('+',
						"Player", new int[] {41,8,47,5},
						new Predicate("agent_attributes", new Term[] {
							Primitive.newPrimitive("@type"),
							Primitive.newPrimitive("ttt:Agent")
						})
					),
					new Declaration(
						new Variable(Type.STRING, "ontology"),
						"Player", new int[] {43,8,47,5},
						new ModuleTerm("ttt", Type.STRING,
							new Predicate("qualifiedName", new Term[] {
								Primitive.newPrimitive("")
							}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.jena.RDFSchema) intention.getModule("Player","ttt")).qualifiedName(
										(java.lang.String) intention.evaluate(predicate.getTerm(0))
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.jena.RDFSchema) visitor.agent().getModule("Player","ttt")).qualifiedName(
										(java.lang.String) visitor.evaluate(predicate.getTerm(0))
									);
								}
							}
						)
					),
					new BeliefUpdate('+',
						"Player", new int[] {44,8,47,5},
						new Predicate("agent_attributes", new Term[] {
							Primitive.newPrimitive("@context"),
							Operator.newOperator('+',
								Primitive.newPrimitive("{\"ttt\": \""),
								Operator.newOperator('+',
									new Variable(Type.STRING, "ontology"),
									Primitive.newPrimitive("\"}")
								)
							)
						})
					),
					new Subgoal(
						"Player", new int[] {46,8,47,5},
						new Goal(
							new Predicate("get_index_page", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {56,9,56,111},
			new GoalEvent('+',
				new Goal(
					new Predicate("get_index_page", new Term[] {})
				)
			),
			new AND(
				new NOT(
					new Predicate("game", new Term[] {
						new Variable(Type.STRING, "id",false),
						new Variable(Type.STRING, "role",false),
						new Variable(Type.STRING, "opponent",false)
					})
				),
				new Predicate("api_index_url", new Term[] {
					new Variable(Type.STRING, "game_url",false)
				})
			),
			new Block(
				"Player", new int[] {56,110,60,5},
				new Statement[] {
					new ModuleCall("knowledgeStoreGame",
						"Player", new int[] {58,8,58,60},
						new Predicate("getKnowledge", new Term[] {
							new Variable(Type.STRING, "game_url"),
							Primitive.newPrimitive("JSON-LD")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.jena.KnowledgeStore) intention.getModule("Player","knowledgeStoreGame")).getKnowledge(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {68,9,68,129},
			new ModuleEvent("knowledgeStoreGame",
				"$re",
				new Predicate("read", new Term[] {
					new Variable(Type.STRING, "url",false)
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.jena.KnowledgeStore) agent.getModule("Player","knowledgeStoreGame")).read(
							predicate.getTerm(0)
						);
					}
				}
			),
			new AND(
				new Predicate("game", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Variable(Type.STRING, "role",false),
					new Variable(Type.STRING, "opponent",false)
				}),
				new ModuleFormula("strings",
					new Predicate("contains", new Term[] {
						new Variable(Type.STRING, "url"),
						Primitive.newPrimitive("result")
					}),
				new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.Strings) visitor.agent().getModule("Player","strings")).contains(
								(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
								(java.lang.String) visitor.evaluate(predicate.getTerm(1))
							);
					}
				}
					)
			),
			new Block(
				"Player", new int[] {68,128,70,5},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {72,9,72,95},
			new ModuleEvent("knowledgeStoreGame",
				"$re",
				new Predicate("read", new Term[] {
					new Variable(Type.STRING, "url",false)
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.jena.KnowledgeStore) agent.getModule("Player","knowledgeStoreGame")).read(
							predicate.getTerm(0)
						);
					}
				}
			),
			new Predicate("game", new Term[] {
				new Variable(Type.STRING, "id",false),
				new Variable(Type.STRING, "role",false),
				new Variable(Type.STRING, "opponent",false)
			}),
			new Block(
				"Player", new int[] {72,94,74,5},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {76,9,76,47},
			new ModuleEvent("knowledgeStoreGame",
				"$re",
				new Predicate("read", new Term[] {
					new Variable(Type.STRING, "url",false)
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.jena.KnowledgeStore) agent.getModule("Player","knowledgeStoreGame")).read(
							predicate.getTerm(0)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {76,46,81,5},
				new Statement[] {
					new ModuleCall("console",
						"Player", new int[] {77,8,77,60},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Processed information from "),
								new Variable(Type.STRING, "url")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Player","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Player", new int[] {79,8,81,5},
						new Goal(
							new Predicate("form_actions", new Term[] {
								new Variable(Type.STRING, "url")
							})
						)
					),
					new Subgoal(
						"Player", new int[] {80,8,81,5},
						new Goal(
							new Predicate("link_actions", new Term[] {
								new Variable(Type.STRING, "url")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {88,9,89,134},
			new BeliefEvent('+',
				new Predicate("form_actions", new Term[] {
					new Variable(Type.STRING, "form_url",false),
					new Variable(Type.STRING, "http_method",false),
					new Variable(Type.LIST, "required_actions",false)
				})
			),
			new AND(
				new NOT(
					new Predicate("game", new Term[] {
						new Variable(Type.STRING, "id",false),
						new Variable(Type.STRING, "role",false),
						new Variable(Type.STRING, "opponent",false)
					})
				),
				new AND(
					new ModuleFormula("strings",
						new Predicate("endsWith", new Term[] {
							new Variable(Type.STRING, "form_url"),
							Primitive.newPrimitive("register")
						}),
					new ModuleFormulaAdaptor() {
							public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
								return ((astra.lang.Strings) visitor.agent().getModule("Player","strings")).endsWith(
									(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
									(java.lang.String) visitor.evaluate(predicate.getTerm(1))
								);
						}
					}
						),
					new AND(
						new Predicate("http_fail_count", new Term[] {
							new Variable(Type.INTEGER, "count",false)
						}),
						new Predicate("agent_attributes", new Term[] {
							Primitive.newPrimitive("@id"),
							new Variable(Type.STRING, "url",false)
						})
					)
				)
			),
			new Block(
				"Player", new int[] {89,133,119,5},
				new Statement[] {
					new TryRecover(
						"Player", new int[] {91,0,119,5},
						new Block(
							"Player", new int[] {91,8,111,9},
							new Statement[] {
								new Declaration(
									new Variable(new ObjectType(JsonNode.class), "bodyJson"),
									"Player", new int[] {93,12,111,9},
									new ModuleTerm("builder", new ObjectType(com.fasterxml.jackson.databind.JsonNode.class),
										new Predicate("createObject", new Term[] {}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((mams.JSONBuilder) intention.getModule("Player","builder")).createObject(
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((mams.JSONBuilder) visitor.agent().getModule("Player","builder")).createObject(
												);
											}
										}
									)
								),
								new ModuleCall("builder",
									"Player", new int[] {94,12,94,52},
									new Predicate("addProperty", new Term[] {
										new Variable(new ObjectType(JsonNode.class), "bodyJson"),
										Primitive.newPrimitive("@id"),
										new Variable(Type.STRING, "url")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((mams.JSONBuilder) intention.getModule("Player","builder")).addProperty(
												(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0)),
												(java.lang.String) intention.evaluate(predicate.getTerm(1)),
												(java.lang.String) intention.evaluate(predicate.getTerm(2))
											);
										}
									}
								),
								new Declaration(
									new Variable(Type.STRING, "bodyStr"),
									"Player", new int[] {96,12,111,9},
									new ModuleTerm("builder", Type.STRING,
										new Predicate("toJsonString", new Term[] {
											new Variable(new ObjectType(JsonNode.class), "bodyJson")
										}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((mams.JSONBuilder) intention.getModule("Player","builder")).toJsonString(
													(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0))
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((mams.JSONBuilder) visitor.agent().getModule("Player","builder")).toJsonString(
													(com.fasterxml.jackson.databind.JsonNode) visitor.evaluate(predicate.getTerm(0))
												);
											}
										}
									)
								),
								new ModuleCall("console",
									"Player", new int[] {97,12,97,32},
									new Predicate("println", new Term[] {
										new Variable(Type.STRING, "url")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new If(
									"Player", new int[] {99,12,111,9},
									new Comparison("==",
										new Variable(Type.STRING, "http_method"),
										Primitive.newPrimitive("POST")
									),
									new Block(
										"Player", new int[] {100,12,104,13},
										new Statement[] {
											new ScopedSubgoal(
												"Player", new int[] {101,16,104,13},
												"MAMSAgent",
												new Goal(
													new Predicate("post", new Term[] {
														new Variable(Type.STRING, "form_url"),
														new Variable(Type.STRING, "bodyStr"),
														new Variable(new ObjectType(HttpResponse.class), "response",false)
													})
												)
											),
											new ModuleCall("console",
												"Player", new int[] {102,16,102,65},
												new Predicate("println", new Term[] {
													new ModuleTerm("httpUtils", Type.STRING,
														new Predicate("bodyAsString", new Term[] {
															new Variable(new ObjectType(HttpResponse.class), "response")
														}),
														new ModuleTermAdaptor() {
															public Object invoke(Intention intention, Predicate predicate) {
																return ((mams.HttpUtils) intention.getModule("Player","httpUtils")).bodyAsString(
																	(mams.web.HttpResponse) intention.evaluate(predicate.getTerm(0))
																);
															}
															public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																return ((mams.HttpUtils) visitor.agent().getModule("Player","httpUtils")).bodyAsString(
																	(mams.web.HttpResponse) visitor.evaluate(predicate.getTerm(0))
																);
															}
														}
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									),
									new Block(
										"Player", new int[] {105,17,111,9},
										new Statement[] {
											new ScopedSubgoal(
												"Player", new int[] {106,16,108,13},
												"MAMSAgent",
												new Goal(
													new Predicate("put", new Term[] {
														new Variable(Type.STRING, "form_url"),
														new Variable(Type.STRING, "bodyStr"),
														new Variable(new ObjectType(HttpResponse.class), "response",false)
													})
												)
											),
											new ModuleCall("console",
												"Player", new int[] {107,16,107,65},
												new Predicate("println", new Term[] {
													new ModuleTerm("httpUtils", Type.STRING,
														new Predicate("bodyAsString", new Term[] {
															new Variable(new ObjectType(HttpResponse.class), "response")
														}),
														new ModuleTermAdaptor() {
															public Object invoke(Intention intention, Predicate predicate) {
																return ((mams.HttpUtils) intention.getModule("Player","httpUtils")).bodyAsString(
																	(mams.web.HttpResponse) intention.evaluate(predicate.getTerm(0))
																);
															}
															public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																return ((mams.HttpUtils) visitor.agent().getModule("Player","httpUtils")).bodyAsString(
																	(mams.web.HttpResponse) visitor.evaluate(predicate.getTerm(0))
																);
															}
														}
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									)
								),
								new Subgoal(
									"Player", new int[] {110,12,111,9},
									new Goal(
										new Predicate("clear_knowledge", new Term[] {})
									)
								)
							}
						),
						new Block(
							"Player", new int[] {112,16,119,5},
							new Statement[] {
								new SpecialBeliefUpdate(
									"Player", new int[] {114,12,117,9},
									new Predicate("http_fail_count", new Term[] {
										Operator.newOperator('+',
											new Variable(Type.INTEGER, "count"),
											Primitive.newPrimitive(1)
										)
									})
								),
								new ModuleCall("console",
									"Player", new int[] {115,12,115,62},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("Failed to register. Retrying...")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new SpecialBeliefUpdate(
									"Player", new int[] {116,12,117,9},
									new Predicate("form_actions", new Term[] {
										new Variable(Type.STRING, "form_url"),
										new Variable(Type.STRING, "http_method"),
										new Variable(Type.LIST, "required_actions")
									})
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {125,9,125,72},
			new BeliefEvent('+',
				new Predicate("http_fail_count", new Term[] {
					new Variable(Type.INTEGER, "i",false)
				})
			),
			new AND(
				new Predicate("failure_threshold", new Term[] {
					new Variable(Type.INTEGER, "j",false)
				}),
				new BracketFormula(
					new Comparison(">=",
						new Variable(Type.INTEGER, "i"),
						new Variable(Type.INTEGER, "j")
					)
				)
			),
			new Block(
				"Player", new int[] {125,71,128,5},
				new Statement[] {
					new ModuleCall("console",
						"Player", new int[] {126,8,126,59},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Too many failures! Shutting down")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Player","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("system",
						"Player", new int[] {127,8,127,21},
						new Predicate("exit", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Player","system")).exit(
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {137,10,137,31},
			new GoalEvent('+',
				new Goal(
					new Predicate("clear_knowledge", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {137,30,146,5},
				new Statement[] {
					new ModuleCall("knowledgeStoreGame",
						"Player", new int[] {138,8,138,34},
						new Predicate("clear", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.jena.KnowledgeStore) intention.getModule("Player","knowledgeStoreGame")).clear(
								);
							}
						}
					),
					new ForEach(
						"Player", new int[] {140,8,146,5},
						new Predicate("form_actions", new Term[] {
							new Variable(Type.STRING, "anyForm",false),
							new Variable(Type.STRING, "method_name",false),
							new Variable(Type.LIST, "any_list",false)
						}),
						new Block(
							"Player", new int[] {140,81,142,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Player", new int[] {141,12,142,9},
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
						"Player", new int[] {143,8,146,5},
						new Predicate("link_actions", new Term[] {
							new Variable(Type.STRING, "anyLink",false)
						}),
						new Block(
							"Player", new int[] {143,46,145,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Player", new int[] {144,12,145,9},
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
		addRule(new Rule(
			"Player", new int[] {148,9,148,89},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("game", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Variable(Type.STRING, "role",false),
					new Variable(Type.STRING, "opponent",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {148,88,151,5},
				new Statement[] {
					new ModuleCall("console",
						"Player", new int[] {150,8,150,109},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("I've been given the game "),
								Operator.newOperator('+',
									new Variable(Type.STRING, "id"),
									Operator.newOperator('+',
										Primitive.newPrimitive(" with role "),
										Operator.newOperator('+',
											new Variable(Type.STRING, "role"),
											Operator.newOperator('+',
												Primitive.newPrimitive(" and opponent "),
												new Variable(Type.STRING, "opponent")
											)
										)
									)
								)
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Player","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {153,9,153,54},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("turn", new Term[] {
					Primitive.newPrimitive(true)
				})
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {153,53,155,5},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {157,9,157,98},
			new BeliefEvent('+',
				new Predicate("turn", new Term[] {
					Primitive.newPrimitive(true)
				})
			),
			new AND(
				new Predicate("game", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Variable(Type.STRING, "role",false),
					new Variable(Type.STRING, "opponent",false)
				}),
				new Predicate("api_index_url", new Term[] {
					new Variable(Type.STRING, "url",false)
				})
			),
			new Block(
				"Player", new int[] {157,97,159,5},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {161,9,161,22},
			new BeliefEvent('-',
				new Predicate("turn", new Term[] {
					Primitive.newPrimitive(true)
				})
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {161,21,163,5},
				new Statement[] {
					new Subgoal(
						"Player", new int[] {162,8,163,5},
						new Goal(
							new Predicate("clear_knowledge", new Term[] {})
						)
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("http_fail_count", new Term[] {
				Primitive.newPrimitive(0)
			})
		);
		agent.initialize(
			new Predicate("failure_threshold", new Term[] {
				Primitive.newPrimitive(10)
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("knowledgeStoreGame",astra.jena.KnowledgeStore.class,agent);
		fragment.addModule("console",astra.lang.Console.class,agent);
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
			astra.core.Agent agent = new Player().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: Player");
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
