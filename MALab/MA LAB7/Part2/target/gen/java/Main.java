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
				"Main", new int[] {21,57,38,5},
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
						"Main", new int[] {25,8,38,5},
						"MAMSAgent",
						new Goal(
							new Predicate("setup", new Term[] {})
						)
					),
					new ScopedSubgoal(
						"Main", new int[] {26,8,38,5},
						"MAMSAgent",
						new Goal(
							new Predicate("created", new Term[] {
								Primitive.newPrimitive("base")
							})
						)
					),
					new ScopedSubgoal(
						"Main", new int[] {27,8,38,5},
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
						"Main", new int[] {32,8,32,48},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("AgentOne"),
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
						"Main", new int[] {33,8,33,50},
						new Predicate("setMainGoal", new Term[] {
							Primitive.newPrimitive("AgentOne"),
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
						"Main", new int[] {35,8,35,25},
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
						"Main", new int[] {37,8,38,5},
						new Goal(
							new Predicate("game", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {40,9,40,52},
			new GoalEvent('+',
				new Goal(
					new Predicate("game", new Term[] {})
				)
			),
			new Predicate("api_index_url", new Term[] {
				new Variable(Type.STRING, "game_url",false)
			}),
			new Block(
				"Main", new int[] {40,51,45,5},
				new Statement[] {
					new ModuleCall("knowledgeStore",
						"Main", new int[] {42,8,42,68},
						new Predicate("getKnowledge", new Term[] {
							Operator.newOperator('+',
								new Variable(Type.STRING, "game_url"),
								Primitive.newPrimitive("players")
							),
							Primitive.newPrimitive("JSON-LD")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.jena.KnowledgeStore) intention.getModule("Main","knowledgeStore")).getKnowledge(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("knowledgeStore",
						"Main", new int[] {43,8,43,37},
						new Predicate("displayModel", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.jena.KnowledgeStore) intention.getModule("Main","knowledgeStore")).displayModel(
								);
							}
						}
					),
					new Subgoal(
						"Main", new int[] {44,8,45,5},
						new Goal(
							new Predicate("form_actions", new Term[] {
								Operator.newOperator('+',
									new Variable(Type.STRING, "game_url"),
									Primitive.newPrimitive("players")
								)
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {47,9,47,78},
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
				"Main", new int[] {47,77,69,5},
				new Statement[] {
					new ModuleCall("console",
						"Main", new int[] {49,8,49,28},
						new Predicate("println", new Term[] {
							new Variable(Type.STRING, "url")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Declaration(
						new Variable(Type.INTEGER, "player_index"),
						"Main", new int[] {55,8,69,5},
						Primitive.newPrimitive(0)
					),
					new ForEach(
						"Main", new int[] {57,8,69,5},
						new ModuleFormula("ttt",
							new Predicate("Agent", new Term[] {
								new Variable(Type.STRING, "url"),
								new Variable(Type.STRING, "agent_url",false)
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.jena.RDFSchema) visitor.agent().getModule("Main","ttt")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						),
						new Block(
							"Main", new int[] {57,49,68,9},
							new Statement[] {
								new ModuleCall("console",
									"Main", new int[] {58,12,58,61},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Available player: "),
											new Variable(Type.STRING, "agent_url")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Main","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new If(
									"Main", new int[] {59,12,68,9},
									new Comparison("==",
										new Variable(Type.INTEGER, "player_index"),
										Primitive.newPrimitive(0)
									),
									new Block(
										"Main", new int[] {59,32,62,9},
										new Statement[] {
											new BeliefUpdate('+',
												"Main", new int[] {60,16,62,9},
												new Predicate("player", new Term[] {
													Primitive.newPrimitive("XPlayerRole"),
													new Variable(Type.STRING, "agent_url")
												})
											),
											new ModuleCall("console",
												"Main", new int[] {61,16,61,72},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("Assigned XPlayerRole to: "),
														new Variable(Type.STRING, "agent_url")
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Main","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									)
								),
								new If(
									"Main", new int[] {63,12,68,9},
									new Comparison("==",
										new Variable(Type.INTEGER, "player_index"),
										Primitive.newPrimitive(1)
									),
									new Block(
										"Main", new int[] {63,32,66,9},
										new Statement[] {
											new BeliefUpdate('+',
												"Main", new int[] {64,16,66,9},
												new Predicate("player", new Term[] {
													Primitive.newPrimitive("OPlayerRole"),
													new Variable(Type.STRING, "agent_url")
												})
											),
											new ModuleCall("console",
												"Main", new int[] {65,16,65,72},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("Assigned OPlayerRole to: "),
														new Variable(Type.STRING, "agent_url")
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Main","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									)
								),
								new Assignment(
									new Variable(Type.INTEGER, "player_index"),
									"Main", new int[] {67,12,68,9},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "player_index"),
										Primitive.newPrimitive(1)
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {71,9,73,5},
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
				"Main", new int[] {73,4,104,5},
				new Statement[] {
					new Declaration(
						new Variable(new ObjectType(JsonNode.class), "bodyJson"),
						"Main", new int[] {75,8,104,5},
						new ModuleTerm("builder", new ObjectType(com.fasterxml.jackson.databind.JsonNode.class),
							new Predicate("createObject", new Term[] {}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((mams.JSONBuilder) intention.getModule("Main","builder")).createObject(
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((mams.JSONBuilder) visitor.agent().getModule("Main","builder")).createObject(
									);
								}
							}
						)
					),
					new ForAll(
						"Main", new int[] {77,8,77,46},
						new Variable(Type.STRING, "item",false),
						new Variable(Type.LIST, "required_actions"),
						new Block(
							"Main", new int[] {77,47,104,5},
							new Statement[] {
								new If(
									"Main", new int[] {78,12,86,9},
									new AND(
										new ModuleFormula("strings",
											new Predicate("equal", new Term[] {
												new Variable(Type.STRING, "item"),
												Primitive.newPrimitive("ttt:OPlayerRole")
											}),
										new ModuleFormulaAdaptor() {
												public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).equal(
														(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
														(java.lang.String) visitor.evaluate(predicate.getTerm(1))
													);
											}
										}
											),
										new Predicate("player", new Term[] {
											Primitive.newPrimitive("OPlayerRole"),
											new Variable(Type.STRING, "playerURL",false)
										})
									),
									new Block(
										"Main", new int[] {79,56,81,13},
										new Statement[] {
											new ModuleCall("builder",
												"Main", new int[] {80,16,80,62},
												new Predicate("addProperty", new Term[] {
													new Variable(new ObjectType(JsonNode.class), "bodyJson"),
													new Variable(Type.STRING, "item"),
													new Variable(Type.STRING, "playerURL")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((mams.JSONBuilder) intention.getModule("Main","builder")).addProperty(
															(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0)),
															(java.lang.String) intention.evaluate(predicate.getTerm(1)),
															(java.lang.String) intention.evaluate(predicate.getTerm(2))
														);
													}
												}
											)
										}
									)
								),
								new If(
									"Main", new int[] {82,12,86,9},
									new AND(
										new ModuleFormula("strings",
											new Predicate("equal", new Term[] {
												new Variable(Type.STRING, "item"),
												Primitive.newPrimitive("ttt:XPlayerRole")
											}),
										new ModuleFormulaAdaptor() {
												public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).equal(
														(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
														(java.lang.String) visitor.evaluate(predicate.getTerm(1))
													);
											}
										}
											),
										new Predicate("player", new Term[] {
											Primitive.newPrimitive("XPlayerRole"),
											new Variable(Type.STRING, "playerURL",false)
										})
									),
									new Block(
										"Main", new int[] {83,56,85,13},
										new Statement[] {
											new ModuleCall("builder",
												"Main", new int[] {84,16,84,62},
												new Predicate("addProperty", new Term[] {
													new Variable(new ObjectType(JsonNode.class), "bodyJson"),
													new Variable(Type.STRING, "item"),
													new Variable(Type.STRING, "playerURL")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((mams.JSONBuilder) intention.getModule("Main","builder")).addProperty(
															(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0)),
															(java.lang.String) intention.evaluate(predicate.getTerm(1)),
															(java.lang.String) intention.evaluate(predicate.getTerm(2))
														);
													}
												}
											)
										}
									)
								)
							}
						)
					),
					new Declaration(
						new Variable(Type.STRING, "bodyStr"),
						"Main", new int[] {88,8,104,5},
						new ModuleTerm("builder", Type.STRING,
							new Predicate("toJsonString", new Term[] {
								new Variable(new ObjectType(JsonNode.class), "bodyJson")
							}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((mams.JSONBuilder) intention.getModule("Main","builder")).toJsonString(
										(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0))
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((mams.JSONBuilder) visitor.agent().getModule("Main","builder")).toJsonString(
										(com.fasterxml.jackson.databind.JsonNode) visitor.evaluate(predicate.getTerm(0))
									);
								}
							}
						)
					),
					new If(
						"Main", new int[] {90,8,104,5},
						new Comparison("==",
							new Variable(Type.STRING, "http_method"),
							Primitive.newPrimitive("POST")
						),
						new Block(
							"Main", new int[] {90,34,95,9},
							new Statement[] {
								new ScopedSubgoal(
									"Main", new int[] {91,12,95,9},
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
									"Main", new int[] {92,12,92,61},
									new Predicate("println", new Term[] {
										new ModuleTerm("httpUtils", Type.STRING,
											new Predicate("bodyAsString", new Term[] {
												new Variable(new ObjectType(HttpResponse.class), "response")
											}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((mams.HttpUtils) intention.getModule("Main","httpUtils")).bodyAsString(
														(mams.web.HttpResponse) intention.evaluate(predicate.getTerm(0))
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((mams.HttpUtils) visitor.agent().getModule("Main","httpUtils")).bodyAsString(
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
											return ((astra.lang.Console) intention.getModule("Main","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Subgoal(
									"Main", new int[] {93,11,95,9},
									new Goal(
										new Predicate("clear_knowledge", new Term[] {})
									)
								),
								new ModuleCall("knowledgeStore",
									"Main", new int[] {94,12,94,93},
									new Predicate("getKnowledgeFromString", new Term[] {
										new ModuleTerm("httpUtils", Type.STRING,
											new Predicate("bodyAsString", new Term[] {
												new Variable(new ObjectType(HttpResponse.class), "response")
											}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((mams.HttpUtils) intention.getModule("Main","httpUtils")).bodyAsString(
														(mams.web.HttpResponse) intention.evaluate(predicate.getTerm(0))
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((mams.HttpUtils) visitor.agent().getModule("Main","httpUtils")).bodyAsString(
														(mams.web.HttpResponse) visitor.evaluate(predicate.getTerm(0))
													);
												}
											}
										),
										new Variable(Type.STRING, "form_url")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.jena.KnowledgeStore) intention.getModule("Main","knowledgeStore")).getKnowledgeFromString(
												(java.lang.String) intention.evaluate(predicate.getTerm(0)),
												(java.lang.String) intention.evaluate(predicate.getTerm(1))
											);
										}
									}
								)
							}
						)
					),
					new If(
						"Main", new int[] {97,8,104,5},
						new Comparison("==",
							new Variable(Type.STRING, "http_method"),
							Primitive.newPrimitive("PUT")
						),
						new Block(
							"Main", new int[] {97,33,102,9},
							new Statement[] {
								new ScopedSubgoal(
									"Main", new int[] {98,16,102,9},
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
									"Main", new int[] {99,16,99,65},
									new Predicate("println", new Term[] {
										new ModuleTerm("httpUtils", Type.STRING,
											new Predicate("bodyAsString", new Term[] {
												new Variable(new ObjectType(HttpResponse.class), "response")
											}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((mams.HttpUtils) intention.getModule("Main","httpUtils")).bodyAsString(
														(mams.web.HttpResponse) intention.evaluate(predicate.getTerm(0))
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((mams.HttpUtils) visitor.agent().getModule("Main","httpUtils")).bodyAsString(
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
											return ((astra.lang.Console) intention.getModule("Main","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Subgoal(
									"Main", new int[] {100,9,102,9},
									new Goal(
										new Predicate("clear_knowledge", new Term[] {})
									)
								),
								new ModuleCall("knowledgeStore",
									"Main", new int[] {101,10,101,91},
									new Predicate("getKnowledgeFromString", new Term[] {
										new ModuleTerm("httpUtils", Type.STRING,
											new Predicate("bodyAsString", new Term[] {
												new Variable(new ObjectType(HttpResponse.class), "response")
											}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((mams.HttpUtils) intention.getModule("Main","httpUtils")).bodyAsString(
														(mams.web.HttpResponse) intention.evaluate(predicate.getTerm(0))
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((mams.HttpUtils) visitor.agent().getModule("Main","httpUtils")).bodyAsString(
														(mams.web.HttpResponse) visitor.evaluate(predicate.getTerm(0))
													);
												}
											}
										),
										new Variable(Type.STRING, "form_url")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.jena.KnowledgeStore) intention.getModule("Main","knowledgeStore")).getKnowledgeFromString(
												(java.lang.String) intention.evaluate(predicate.getTerm(0)),
												(java.lang.String) intention.evaluate(predicate.getTerm(1))
											);
										}
									}
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {106,9,106,83},
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
				"Main", new int[] {106,82,116,5},
				new Statement[] {
					new If(
						"Main", new int[] {109,8,116,5},
						new AND(
							new ModuleFormula("ttt",
								new Predicate("hasID", new Term[] {
									new Variable(Type.STRING, "url"),
									new Variable(Type.STRING, "gameID",false)
								}),
								new ModuleFormulaAdaptor() {
									public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.jena.RDFSchema) visitor.agent().getModule("Main","ttt")).auto_formula((Predicate) predicate.accept(visitor));
									}
								}
							),
							new AND(
								new Predicate("player", new Term[] {
									Primitive.newPrimitive("XPlayerRole"),
									new Variable(Type.STRING, "player1URL",false)
								}),
								new Predicate("player", new Term[] {
									Primitive.newPrimitive("OPlayerRole"),
									new Variable(Type.STRING, "player2URL",false)
								})
							)
						),
						new Block(
							"Main", new int[] {109,124,115,9},
							new Statement[] {
								new ModuleCall("console",
									"Main", new int[] {110,12,110,51},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Game ID is "),
											new Variable(Type.STRING, "gameID")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Main","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Send("Main", new int[] {111,12,111,75},
									new Performative("inform"),
									new Variable(Type.STRING, "player1URL"),
									new Predicate("game", new Term[] {
										new Variable(Type.STRING, "gameID"),
										Primitive.newPrimitive("XPlayerRole"),
										new Variable(Type.STRING, "player2URL")
									})
								),
								new Send("Main", new int[] {112,12,112,75},
									new Performative("inform"),
									new Variable(Type.STRING, "player2URL"),
									new Predicate("game", new Term[] {
										new Variable(Type.STRING, "gameID"),
										Primitive.newPrimitive("OPlayerRole"),
										new Variable(Type.STRING, "player1URL")
									})
								),
								new ModuleCall("console",
									"Main", new int[] {114,12,114,99},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Game details sent to players: "),
											Operator.newOperator('+',
												Primitive.newPrimitive("XPlayerRole"),
												Operator.newOperator('+',
													Primitive.newPrimitive(" and "),
													Primitive.newPrimitive("OPlayerRole")
												)
											)
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Main","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {125,10,125,31},
			new GoalEvent('+',
				new Goal(
					new Predicate("clear_knowledge", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {125,30,134,5},
				new Statement[] {
					new ModuleCall("knowledgeStore",
						"Main", new int[] {126,8,126,30},
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
						"Main", new int[] {128,8,134,5},
						new Predicate("form_actions", new Term[] {
							new Variable(Type.STRING, "anyForm",false),
							new Variable(Type.STRING, "method_name",false),
							new Variable(Type.LIST, "any_list",false)
						}),
						new Block(
							"Main", new int[] {128,81,130,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Main", new int[] {129,12,130,9},
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
						"Main", new int[] {131,8,134,5},
						new Predicate("link_actions", new Term[] {
							new Variable(Type.STRING, "anyLink",false)
						}),
						new Block(
							"Main", new int[] {131,46,133,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Main", new int[] {132,12,133,9},
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
