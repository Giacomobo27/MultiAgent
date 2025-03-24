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
				"Main", new int[] {40,51,44,5},
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
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {46,9,46,78},
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
				"Main", new int[] {46,77,72,5},
				new Statement[] {
					new ModuleCall("console",
						"Main", new int[] {48,8,48,60},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Players data received from "),
								new Variable(Type.STRING, "url")
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
					new Declaration(
						new Variable(Type.INTEGER, "count"),
						"Main", new int[] {54,8,72,5},
						Primitive.newPrimitive(1)
					),
					new ForEach(
						"Main", new int[] {55,8,72,5},
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
							"Main", new int[] {55,49,67,9},
							new Statement[] {
								new ModuleCall("console",
									"Main", new int[] {56,12,56,61},
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
									"Main", new int[] {57,12,67,9},
									new Comparison("~=",
										Operator.newOperator('%',
											new Variable(Type.INTEGER, "count"),
											Primitive.newPrimitive(2)
										),
										Primitive.newPrimitive(0)
									),
									new Block(
										"Main", new int[] {58,12,61,13},
										new Statement[] {
											new BeliefUpdate('+',
												"Main", new int[] {59,16,61,13},
												new Predicate("player", new Term[] {
													Primitive.newPrimitive("XPlayerRole"),
													new Variable(Type.STRING, "agent_url")
												})
											),
											new ModuleCall("console",
												"Main", new int[] {60,16,60,72},
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
									),
									new Block(
										"Main", new int[] {62,16,67,9},
										new Statement[] {
											new BeliefUpdate('+',
												"Main", new int[] {63,16,65,13},
												new Predicate("player", new Term[] {
													Primitive.newPrimitive("OPlayerRole"),
													new Variable(Type.STRING, "agent_url")
												})
											),
											new ModuleCall("console",
												"Main", new int[] {64,16,64,72},
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
									new Variable(Type.INTEGER, "count"),
									"Main", new int[] {66,12,67,9},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "count"),
										Primitive.newPrimitive(1)
									)
								)
							}
						)
					),
					new Subgoal(
						"Main", new int[] {70,8,72,5},
						new Goal(
							new Predicate("form_actions", new Term[] {
								new Variable(Type.STRING, "url")
							})
						)
					),
					new Subgoal(
						"Main", new int[] {71,8,72,5},
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
			"Main", new int[] {74,9,75,6},
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
				"Main", new int[] {75,5,109,5},
				new Statement[] {
					new Declaration(
						new Variable(new ObjectType(JsonNode.class), "bodyJson"),
						"Main", new int[] {77,8,109,5},
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
						"Main", new int[] {80,8,80,47},
						new Variable(Type.STRING, "item",false),
						new Variable(Type.LIST, "required_actions"),
						new Block(
							"Main", new int[] {80,48,109,5},
							new Statement[] {
								new If(
									"Main", new int[] {81,12,87,9},
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
											new Variable(Type.STRING, "playerX",false)
										})
									),
									new Block(
										"Main", new int[] {81,94,83,13},
										new Statement[] {
											new ModuleCall("builder",
												"Main", new int[] {82,16,82,60},
												new Predicate("addProperty", new Term[] {
													new Variable(new ObjectType(JsonNode.class), "bodyJson"),
													new Variable(Type.STRING, "item"),
													new Variable(Type.STRING, "playerX")
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
									"Main", new int[] {84,12,87,9},
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
											new Variable(Type.STRING, "playerO",false)
										})
									),
									new Block(
										"Main", new int[] {84,94,86,13},
										new Statement[] {
											new ModuleCall("builder",
												"Main", new int[] {85,16,85,60},
												new Predicate("addProperty", new Term[] {
													new Variable(new ObjectType(JsonNode.class), "bodyJson"),
													new Variable(Type.STRING, "item"),
													new Variable(Type.STRING, "playerO")
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
						"Main", new int[] {88,8,109,5},
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
					new Declaration(
						new Variable(new ObjectType(HttpResponse.class), "response"),
						"Main", new int[] {89,8,109,5}
					),
					new If(
						"Main", new int[] {92,8,109,5},
						new ModuleFormula("strings",
							new Predicate("equal", new Term[] {
								new Variable(Type.STRING, "http_method"),
								Primitive.newPrimitive("POST")
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
						new Block(
							"Main", new int[] {93,8,97,9},
							new Statement[] {
								new ScopedSubgoal(
									"Main", new int[] {95,12,97,9},
									"MAMSAgent",
									new Goal(
										new Predicate("post", new Term[] {
											new Variable(Type.STRING, "form_url"),
											new Variable(Type.STRING, "bodyStr"),
											new Variable(new ObjectType(HttpResponse.class), "response")
										})
									)
								),
								new ModuleCall("console",
									"Main", new int[] {96,12,96,61},
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
								)
							}
						),
						new Block(
							"Main", new int[] {98,8,109,5},
							new Statement[] {
								new ScopedSubgoal(
									"Main", new int[] {100,12,102,9},
									"MAMSAgent",
									new Goal(
										new Predicate("put", new Term[] {
											new Variable(Type.STRING, "form_url"),
											new Variable(Type.STRING, "bodyStr"),
											new Variable(new ObjectType(HttpResponse.class), "response")
										})
									)
								),
								new ModuleCall("console",
									"Main", new int[] {101,12,101,61},
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
								)
							}
						)
					),
					new ModuleCall("knowledgeStore",
						"Main", new int[] {105,8,105,30},
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
					new ModuleCall("knowledgeStore",
						"Main", new int[] {106,8,106,89},
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
					),
					new ModuleCall("console",
						"Main", new int[] {107,8,107,73},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Knowledge store updated after form submission.")
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
		));
		addRule(new Rule(
			"Main", new int[] {111,9,112,5},
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
				"Main", new int[] {112,4,132,5},
				new Statement[] {
					new If(
						"Main", new int[] {114,8,132,5},
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
						new Block(
							"Main", new int[] {115,8,131,9},
							new Statement[] {
								new ModuleCall("console",
									"Main", new int[] {116,12,116,51},
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
								new Query(
									"Main", new int[] {118,12,118,54},
									new Predicate("player", new Term[] {
										Primitive.newPrimitive("XPlayerRole"),
										new Variable(Type.STRING, "playerX",false)
									})
								),
								new Query(
									"Main", new int[] {119,12,119,54},
									new Predicate("player", new Term[] {
										Primitive.newPrimitive("OPlayerRole"),
										new Variable(Type.STRING, "playerO",false)
									})
								),
								new Declaration(
									new Variable(Type.STRING, "gameMessageX"),
									"Main", new int[] {122,16,131,9},
									Operator.newOperator('+',
										Primitive.newPrimitive("game("),
										Operator.newOperator('+',
											new Variable(Type.STRING, "gameID"),
											Operator.newOperator('+',
												Primitive.newPrimitive(", XPlayerRole, "),
												Operator.newOperator('+',
													new Variable(Type.STRING, "playerX"),
													Operator.newOperator('+',
														Primitive.newPrimitive(", "),
														Operator.newOperator('+',
															new Variable(Type.STRING, "playerO"),
															Primitive.newPrimitive(")")
														)
													)
												)
											)
										)
									)
								),
								new Declaration(
									new Variable(Type.STRING, "gameMessageO"),
									"Main", new int[] {123,16,131,9},
									Operator.newOperator('+',
										Primitive.newPrimitive("game("),
										Operator.newOperator('+',
											new Variable(Type.STRING, "gameID"),
											Operator.newOperator('+',
												Primitive.newPrimitive(", OPlayerRole, "),
												Operator.newOperator('+',
													new Variable(Type.STRING, "playerO"),
													Operator.newOperator('+',
														Primitive.newPrimitive(", "),
														Operator.newOperator('+',
															new Variable(Type.STRING, "playerX"),
															Primitive.newPrimitive(")")
														)
													)
												)
											)
										)
									)
								),
								new Send("Main", new int[] {126,16,126,69},
									new Performative("inform"),
									new Variable(Type.STRING, "playerX"),
									new Predicate("game", new Term[] {
										new Variable(Type.STRING, "gameID"),
										new Variable(Type.STRING, "playerX"),
										new Variable(Type.STRING, "playerO")
									})
								),
								new Send("Main", new int[] {127,16,127,69},
									new Performative("inform"),
									new Variable(Type.STRING, "playerO"),
									new Predicate("game", new Term[] {
										new Variable(Type.STRING, "gameID"),
										new Variable(Type.STRING, "playerO"),
										new Variable(Type.STRING, "playerX")
									})
								),
								new ModuleCall("console",
									"Main", new int[] {129,16,129,95},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Game details sent to players: "),
											Operator.newOperator('+',
												new Variable(Type.STRING, "playerX"),
												Operator.newOperator('+',
													Primitive.newPrimitive(" and "),
													new Variable(Type.STRING, "playerO")
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
			"Main", new int[] {141,10,141,31},
			new GoalEvent('+',
				new Goal(
					new Predicate("clear_knowledge", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {141,30,150,5},
				new Statement[] {
					new ModuleCall("knowledgeStore",
						"Main", new int[] {142,8,142,30},
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
						"Main", new int[] {144,8,150,5},
						new Predicate("form_actions", new Term[] {
							new Variable(Type.STRING, "anyForm",false),
							new Variable(Type.STRING, "method_name",false),
							new Variable(Type.LIST, "any_list",false)
						}),
						new Block(
							"Main", new int[] {144,81,146,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Main", new int[] {145,12,146,9},
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
						"Main", new int[] {147,8,150,5},
						new Predicate("link_actions", new Term[] {
							new Variable(Type.STRING, "anyLink",false)
						}),
						new Block(
							"Main", new int[] {147,46,149,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Main", new int[] {148,12,149,9},
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
