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


public class Player extends ASTRAClass {
	public Player() {
		setParents(new Class[] {astra.lang.Agent.class});
		addInference(new Inference(
			new Predicate("free", new Term[] {
				new Variable(Type.INTEGER, "L",false)
			}),
			new AND(
				new Predicate("location", new Term[] {
					new Variable(Type.INTEGER, "L")
				}),
				new NOT(
					new Predicate("played", new Term[] {
						new Variable(Type.STRING, "T",false),
						new Variable(Type.INTEGER, "L")
					})
				)
			)
		));
		addInference(new Inference(
			new Predicate("winner", new Term[] {
				new Variable(Type.STRING, "T",false)
			}),
			new AND(
				new Predicate("line", new Term[] {
					new Variable(Type.INTEGER, "L1",false),
					new Variable(Type.INTEGER, "L2",false),
					new Variable(Type.INTEGER, "L3",false)
				}),
				new AND(
					new Predicate("played", new Term[] {
						new Variable(Type.STRING, "T"),
						new Variable(Type.INTEGER, "L1")
					}),
					new AND(
						new Predicate("played", new Term[] {
							new Variable(Type.STRING, "T"),
							new Variable(Type.INTEGER, "L2")
						}),
						new Predicate("played", new Term[] {
							new Variable(Type.STRING, "T"),
							new Variable(Type.INTEGER, "L3")
						})
					)
				)
			)
		));
		addInference(new Inference(
			new Predicate("loser", new Term[] {
				new Variable(Type.STRING, "T",false)
			}),
			new AND(
				new Predicate("player", new Term[] {
					new Variable(Type.STRING, "T")
				}),
				new AND(
					new Predicate("winner", new Term[] {
						new Variable(Type.STRING, "T2",false)
					}),
					new Comparison("~=",
						new Variable(Type.STRING, "T"),
						new Variable(Type.STRING, "T2")
					)
				)
			)
		));
		addInference(new Inference(
			new Predicate("drawn", new Term[] {}),
			new AND(
				new NOT(
					new Predicate("free", new Term[] {
						new Variable(Type.INTEGER, "L",false)
					})
				),
				new NOT(
					new Predicate("winner", new Term[] {
						new Variable(Type.STRING, "T2",false)
					})
				)
			)
		));
		addInference(new Inference(
			new Predicate("notfinished", new Term[] {}),
			new AND(
				new NOT(
					new Predicate("drawn", new Term[] {})
				),
				new NOT(
					new Predicate("winner", new Term[] {
						new Variable(Type.STRING, "T2",false)
					})
				)
			)
		));
		addRule(new Rule(
			"Player", new int[] {56,5,56,50},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new ListTerm(new Term[] {
							new Variable(Type.STRING, "T",false),
							new Variable(Type.STRING, "opp",false),
							new Variable(Type.BOOLEAN, "turn",false)
						})
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {56,49,104,1},
				new Statement[] {
					new If(
						"Player", new int[] {58,4,104,1},
						new NOT(
							new Predicate("played", new Term[] {
								new Variable(Type.STRING, "K",false),
								new Variable(Type.INTEGER, "L",false)
							})
						),
						new ModuleCall("C",
							"Player", new int[] {59,2,59,35},
							new Predicate("println", new Term[] {
								Primitive.newPrimitive("Game has not Started")
							}),
							new DefaultModuleCallAdaptor() {
								public boolean inline() {
									return true;
								}

								public boolean invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.Console) intention.getModule("Player","C")).println(
										(java.lang.String) intention.evaluate(predicate.getTerm(0))
									);
								}
							}
						)
					),
					new If(
						"Player", new int[] {61,2,104,1},
						new Predicate("free", new Term[] {
							new Variable(Type.INTEGER, "L",false)
						}),
						new ModuleCall("C",
							"Player", new int[] {62,2,62,38},
							new Predicate("println", new Term[] {
								Operator.newOperator('+',
									Primitive.newPrimitive("first free location: "),
									new Variable(Type.INTEGER, "L")
								)
							}),
							new DefaultModuleCallAdaptor() {
								public boolean inline() {
									return true;
								}

								public boolean invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.Console) intention.getModule("Player","C")).println(
										(java.lang.String) intention.evaluate(predicate.getTerm(0))
									);
								}
							}
						)
					),
					new BeliefUpdate('+',
						"Player", new int[] {65,4,104,1},
						new Predicate("player", new Term[] {
							new Variable(Type.STRING, "T")
						})
					),
					new BeliefUpdate('+',
						"Player", new int[] {66,4,104,1},
						new Predicate("opponent", new Term[] {
							new Variable(Type.STRING, "opp")
						})
					),
					new Declaration(
						new Variable(Type.STRING, "opptoken"),
						"Player", new int[] {68,4,104,1}
					),
					new If(
						"Player", new int[] {70,5,104,1},
						new Comparison("==",
							new Variable(Type.STRING, "T"),
							Primitive.newPrimitive("X")
						),
						new Block(
							"Player", new int[] {70,15,72,5},
							new Statement[] {
								new Assignment(
									new Variable(Type.STRING, "opptoken"),
									"Player", new int[] {71,8,72,5},
									Primitive.newPrimitive("O")
								)
							}
						),
						new If(
							"Player", new int[] {73,9,104,1},
							new Comparison("==",
								new Variable(Type.STRING, "T"),
								Primitive.newPrimitive("O")
							),
							new Block(
								"Player", new int[] {73,19,75,5},
								new Statement[] {
									new Assignment(
										new Variable(Type.STRING, "opptoken"),
										"Player", new int[] {74,8,75,5},
										Primitive.newPrimitive("X")
									)
								}
							)
						)
					),
					new BeliefUpdate('+',
						"Player", new int[] {77,4,104,1},
						new Predicate("player", new Term[] {
							new Variable(Type.STRING, "opptoken")
						})
					),
					new If(
						"Player", new int[] {81,4,104,1},
						new Comparison("==",
							new Variable(Type.STRING, "opp"),
							Primitive.newPrimitive("player2")
						),
						new Block(
							"Player", new int[] {81,22,85,5},
							new Statement[] {
							}
						),
						new If(
							"Player", new int[] {86,9,104,1},
							new Comparison("==",
								new Variable(Type.STRING, "opp"),
								Primitive.newPrimitive("player1")
							),
							new Block(
								"Player", new int[] {86,27,90,5},
								new Statement[] {
								}
							)
						)
					),
					new If(
						"Player", new int[] {95,4,104,1},
						new BooleanTermFormula(
							new Variable(Type.BOOLEAN, "turn")
						),
						new Block(
							"Player", new int[] {95,12,98,5},
							new Statement[] {
								new BeliefUpdate('+',
									"Player", new int[] {96,8,98,5},
									new Predicate("turn", new Term[] {
										new Variable(Type.STRING, "T")
									})
								),
								new ModuleCall("C",
									"Player", new int[] {97,8,97,45},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Match started with: "),
											new Variable(Type.STRING, "T")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","C")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								)
							}
						),
						new Block(
							"Player", new int[] {99,8,104,1},
							new Statement[] {
								new ModuleCall("C",
									"Player", new int[] {100,8,100,52},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Match doesnt started with: "),
											new Variable(Type.STRING, "T")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","C")).println(
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
			"Player", new int[] {108,5,108,34},
			new BeliefEvent('+',
				new Predicate("turn", new Term[] {
					new Variable(Type.STRING, "T",false)
				})
			),
			new Predicate("player", new Term[] {
				new Variable(Type.STRING, "T")
			}),
			new Block(
				"Player", new int[] {108,33,126,1},
				new Statement[] {
					new ModuleCall("C",
						"Player", new int[] {109,0,109,20},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("turn!!!")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Player","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new If(
						"Player", new int[] {111,0,126,1},
						new AND(
							new Predicate("turn", new Term[] {
								new Variable(Type.STRING, "T")
							}),
							new Predicate("winner", new Term[] {
								new Variable(Type.STRING, "W",false)
							})
						),
						new Block(
							"Player", new int[] {111,30,114,1},
							new Statement[] {
								new BeliefUpdate('-',
									"Player", new int[] {112,4,114,1},
									new Predicate("turn", new Term[] {
										new Variable(Type.STRING, "T")
									})
								),
								new ModuleCall("C",
									"Player", new int[] {113,4,113,29},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Winner: "),
											new Variable(Type.STRING, "W")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","C")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								)
							}
						)
					),
					new If(
						"Player", new int[] {115,0,126,1},
						new AND(
							new Predicate("turn", new Term[] {
								new Variable(Type.STRING, "T")
							}),
							new Predicate("drawn", new Term[] {})
						),
						new Block(
							"Player", new int[] {115,21,118,1},
							new Statement[] {
								new BeliefUpdate('-',
									"Player", new int[] {116,4,118,1},
									new Predicate("turn", new Term[] {
										new Variable(Type.STRING, "T")
									})
								),
								new ModuleCall("C",
									"Player", new int[] {117,4,117,23},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("Drawn!")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","C")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								)
							}
						),
						new Block(
							"Player", new int[] {119,4,126,1},
							new Statement[] {
								new Subgoal(
									"Player", new int[] {120,0,125,1},
									new Goal(
										new Predicate("move", new Term[] {
											new Variable(Type.INTEGER, "L",false)
										})
									)
								),
								new Subgoal(
									"Player", new int[] {121,0,125,1},
									new Goal(
										new Predicate("played", new Term[] {
											new Variable(Type.STRING, "T"),
											new Variable(Type.INTEGER, "L")
										})
									)
								),
								new BeliefUpdate('-',
									"Player", new int[] {124,0,125,1},
									new Predicate("turn", new Term[] {
										new Variable(Type.STRING, "T")
									})
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {129,5,129,42},
			new GoalEvent('+',
				new Goal(
					new Predicate("played", new Term[] {
						new Variable(Type.STRING, "T",false),
						new Variable(Type.INTEGER, "L",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				new Variable(Type.INTEGER, "L")
			}),
			new Block(
				"Player", new int[] {129,41,143,1},
				new Statement[] {
					new BeliefUpdate('+',
						"Player", new int[] {130,0,143,1},
						new Predicate("played", new Term[] {
							new Variable(Type.STRING, "T"),
							new Variable(Type.INTEGER, "L")
						})
					),
					new Declaration(
						new Variable(Type.STRING, "opp1"),
						"Player", new int[] {134,0,143,1},
						Primitive.newPrimitive("player1")
					),
					new Declaration(
						new Variable(Type.STRING, "opp2"),
						"Player", new int[] {135,0,143,1},
						Primitive.newPrimitive("player2")
					),
					new If(
						"Player", new int[] {136,0,143,1},
						new Predicate("opponent", new Term[] {
							new Variable(Type.STRING, "opp1")
						}),
						new Block(
							"Player", new int[] {136,18,138,1},
							new Statement[] {
								new Send("Player", new int[] {137,0,137,32},
									new Performative("inform"),
									new Variable(Type.STRING, "opp1"),
									new Predicate("played", new Term[] {
										new Variable(Type.STRING, "T"),
										new Variable(Type.INTEGER, "L")
									})
								)
							}
						)
					),
					new If(
						"Player", new int[] {139,0,143,1},
						new Predicate("opponent", new Term[] {
							new Variable(Type.STRING, "opp2")
						}),
						new Block(
							"Player", new int[] {139,18,141,1},
							new Statement[] {
								new Send("Player", new int[] {140,0,140,32},
									new Performative("inform"),
									new Variable(Type.STRING, "opp2"),
									new Predicate("played", new Term[] {
										new Variable(Type.STRING, "T"),
										new Variable(Type.INTEGER, "L")
									})
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {147,5,147,79},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("played", new Term[] {
					new Variable(Type.STRING, "T",false),
					new Variable(Type.INTEGER, "L",false)
				})
			),
			new Predicate("notfinished", new Term[] {}),
			new Block(
				"Player", new int[] {147,78,162,1},
				new Statement[] {
					new BeliefUpdate('+',
						"Player", new int[] {148,4,162,1},
						new Predicate("played", new Term[] {
							new Variable(Type.STRING, "T"),
							new Variable(Type.INTEGER, "L")
						})
					),
					new If(
						"Player", new int[] {149,5,162,1},
						new Predicate("free", new Term[] {
							new Variable(Type.INTEGER, "k",false)
						}),
						new ModuleCall("C",
							"Player", new int[] {149,21,149,57},
							new Predicate("println", new Term[] {
								Operator.newOperator('+',
									Primitive.newPrimitive("first free location: "),
									new Variable(Type.INTEGER, "k")
								)
							}),
							new DefaultModuleCallAdaptor() {
								public boolean inline() {
									return true;
								}

								public boolean invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.Console) intention.getModule("Player","C")).println(
										(java.lang.String) intention.evaluate(predicate.getTerm(0))
									);
								}
							}
						)
					),
					new ModuleCall("C",
						"Player", new int[] {151,4,151,51},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("msg recieved from sender:"),
								new Variable(Type.STRING, "sender")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Player","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new If(
						"Player", new int[] {155,4,162,1},
						new Comparison("==",
							new Variable(Type.STRING, "T"),
							Primitive.newPrimitive("X")
						),
						new Block(
							"Player", new int[] {155,14,157,5},
							new Statement[] {
								new BeliefUpdate('+',
									"Player", new int[] {156,8,157,5},
									new Predicate("turn", new Term[] {
										Primitive.newPrimitive("O")
									})
								)
							}
						)
					),
					new If(
						"Player", new int[] {158,4,162,1},
						new Comparison("==",
							new Variable(Type.STRING, "T"),
							Primitive.newPrimitive("O")
						),
						new Block(
							"Player", new int[] {158,14,160,5},
							new Statement[] {
								new BeliefUpdate('+',
									"Player", new int[] {159,9,160,5},
									new Predicate("turn", new Term[] {
										Primitive.newPrimitive("X")
									})
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {164,5,164,31},
			new BeliefEvent('+',
				new Predicate("played", new Term[] {
					new Variable(Type.STRING, "P",false),
					new Variable(Type.INTEGER, "L",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {164,30,166,1},
				new Statement[] {
					new ModuleCall("C",
						"Player", new int[] {165,0,165,54},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Player "),
								Operator.newOperator('+',
									new Variable(Type.STRING, "P"),
									Operator.newOperator('+',
										Primitive.newPrimitive(" played at location: "),
										new Variable(Type.INTEGER, "L")
									)
								)
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Player","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("location", new Term[] {
				Primitive.newPrimitive(1)
			})
		);
		agent.initialize(
			new Predicate("location", new Term[] {
				Primitive.newPrimitive(2)
			})
		);
		agent.initialize(
			new Predicate("location", new Term[] {
				Primitive.newPrimitive(3)
			})
		);
		agent.initialize(
			new Predicate("location", new Term[] {
				Primitive.newPrimitive(4)
			})
		);
		agent.initialize(
			new Predicate("location", new Term[] {
				Primitive.newPrimitive(5)
			})
		);
		agent.initialize(
			new Predicate("location", new Term[] {
				Primitive.newPrimitive(6)
			})
		);
		agent.initialize(
			new Predicate("location", new Term[] {
				Primitive.newPrimitive(7)
			})
		);
		agent.initialize(
			new Predicate("location", new Term[] {
				Primitive.newPrimitive(8)
			})
		);
		agent.initialize(
			new Predicate("location", new Term[] {
				Primitive.newPrimitive(9)
			})
		);
		agent.initialize(
			new Predicate("line", new Term[] {
				Primitive.newPrimitive(1),
				Primitive.newPrimitive(2),
				Primitive.newPrimitive(3)
			})
		);
		agent.initialize(
			new Predicate("line", new Term[] {
				Primitive.newPrimitive(1),
				Primitive.newPrimitive(5),
				Primitive.newPrimitive(9)
			})
		);
		agent.initialize(
			new Predicate("line", new Term[] {
				Primitive.newPrimitive(1),
				Primitive.newPrimitive(4),
				Primitive.newPrimitive(7)
			})
		);
		agent.initialize(
			new Predicate("line", new Term[] {
				Primitive.newPrimitive(2),
				Primitive.newPrimitive(5),
				Primitive.newPrimitive(8)
			})
		);
		agent.initialize(
			new Predicate("line", new Term[] {
				Primitive.newPrimitive(3),
				Primitive.newPrimitive(6),
				Primitive.newPrimitive(9)
			})
		);
		agent.initialize(
			new Predicate("line", new Term[] {
				Primitive.newPrimitive(3),
				Primitive.newPrimitive(5),
				Primitive.newPrimitive(7)
			})
		);
		agent.initialize(
			new Predicate("line", new Term[] {
				Primitive.newPrimitive(4),
				Primitive.newPrimitive(5),
				Primitive.newPrimitive(6)
			})
		);
		agent.initialize(
			new Predicate("line", new Term[] {
				Primitive.newPrimitive(7),
				Primitive.newPrimitive(8),
				Primitive.newPrimitive(9)
			})
		);
		agent.initialize(
			new Predicate("token", new Term[] {
				Primitive.newPrimitive("X")
			})
		);
		agent.initialize(
			new Predicate("token", new Term[] {
				Primitive.newPrimitive("O")
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("C",astra.lang.Console.class,agent);
		fragment.addModule("system",astra.lang.System.class,agent);
		fragment.addModule("math",astra.lang.Math.class,agent);
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
