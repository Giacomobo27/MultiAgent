package old;
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


public class HealthFanatic extends ASTRAClass {
	public HealthFanatic() {
		setParents(new Class[] {astra.lang.Agent.class});
		addInference(new Inference(
			new Predicate("has", new Term[] {
				new Variable(Type.STRING, "X",false)
			}),
			new AND(
				new Predicate("quantity", new Term[] {
					new Variable(Type.STRING, "X"),
					new Variable(Type.INTEGER, "Y",false)
				}),
				new Comparison(">",
					new Variable(Type.INTEGER, "Y"),
					Primitive.newPrimitive(0)
				)
			)
		));
		addRule(new Rule(
			"old.HealthFanatic", new int[] {32,9,32,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"old.HealthFanatic", new int[] {32,27,34,5},
				new Statement[] {
					new SpawnGoal(
						"old.HealthFanatic", new int[] {33,8,34,5},
						new Goal(
							new Predicate("simulate", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"old.HealthFanatic", new int[] {36,9,36,70},
			new GoalEvent('+',
				new Goal(
					new Predicate("simulate", new Term[] {})
				)
			),
			new AND(
				new Predicate("time", new Term[] {
					new Variable(Type.INTEGER, "T",false)
				}),
				new AND(
					new Comparison("==",
						new Variable(Type.INTEGER, "T"),
						Primitive.newPrimitive(24)
					),
					new Predicate("thirst_level", new Term[] {
						new Variable(Type.INTEGER, "L",false)
					})
				)
			),
			new Block(
				"old.HealthFanatic", new int[] {36,69,40,5},
				new Statement[] {
					new ModuleCall("C",
						"old.HealthFanatic", new int[] {37,8,37,38},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("End of Simulation")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("old.HealthFanatic","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("C",
						"old.HealthFanatic", new int[] {38,8,38,39},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("THIRST LEVEL: "),
								new Variable(Type.INTEGER, "L")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("old.HealthFanatic","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("S",
						"old.HealthFanatic", new int[] {39,8,39,16},
						new Predicate("exit", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("old.HealthFanatic","S")).exit(
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"old.HealthFanatic", new int[] {42,9,42,63},
			new GoalEvent('+',
				new Goal(
					new Predicate("simulate", new Term[] {})
				)
			),
			new AND(
				new Predicate("time", new Term[] {
					new Variable(Type.INTEGER, "T",false)
				}),
				new Predicate("thirst_level", new Term[] {
					new Variable(Type.INTEGER, "level",false)
				})
			),
			new Block(
				"old.HealthFanatic", new int[] {42,62,47,5},
				new Statement[] {
					new Subgoal(
						"old.HealthFanatic", new int[] {43,8,47,5},
						new Goal(
							new Predicate("thirst_level", new Term[] {
								Operator.newOperator('-',
									new Variable(Type.INTEGER, "level"),
									Primitive.newPrimitive(2)
								)
							})
						)
					),
					new ModuleCall("S",
						"old.HealthFanatic", new int[] {44,8,44,20},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(1000)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("old.HealthFanatic","S")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"old.HealthFanatic", new int[] {45,8,47,5},
						new Goal(
							new Predicate("time", new Term[] {
								Operator.newOperator('+',
									new Variable(Type.INTEGER, "T"),
									Primitive.newPrimitive(1)
								)
							})
						)
					),
					new Subgoal(
						"old.HealthFanatic", new int[] {46,8,47,5},
						new Goal(
							new Predicate("simulate", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"old.HealthFanatic", new int[] {49,30,51,5},
			new GoalEvent('+',
				new Goal(
					new Predicate("thirst_level", new Term[] {
						new Variable(Type.INTEGER, "level",false)
					})
				)
			),
			Predicate.TRUE,
			new SynchronizedBlock(
				"old.HealthFanatic", new int[] {49,56,51,5},
				"thirst",
				new Block(
					"old.HealthFanatic", new int[] {49,56,51,5},
					new Statement[] {
						new If(
							"old.HealthFanatic", new int[] {50,8,51,5},
							new Comparison(">",
								new Variable(Type.INTEGER, "level"),
								Primitive.newPrimitive(0)
							),
							new SpecialBeliefUpdate(
								"old.HealthFanatic", new int[] {50,22,51,5},
								new Predicate("thirst_level", new Term[] {
									new Variable(Type.INTEGER, "level")
								})
							)
						)
					}
				)
			)
		));
		addRule(new Rule(
			"old.HealthFanatic", new int[] {53,9,53,35},
			new BeliefEvent('+',
				new Predicate("thirst_level", new Term[] {
					new Variable(Type.INTEGER, "level",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"old.HealthFanatic", new int[] {53,34,57,5},
				new Statement[] {
					new If(
						"old.HealthFanatic", new int[] {54,8,57,5},
						new Comparison("<",
							new Variable(Type.INTEGER, "level"),
							Primitive.newPrimitive(8)
						),
						new BeliefUpdate('+',
							"old.HealthFanatic", new int[] {54,22,57,5},
							new Predicate("thirsty", new Term[] {})
						)
					),
					new If(
						"old.HealthFanatic", new int[] {55,8,57,5},
						new Comparison(">",
							new Variable(Type.INTEGER, "level"),
							Primitive.newPrimitive(12)
						),
						new BeliefUpdate('-',
							"old.HealthFanatic", new int[] {55,23,57,5},
							new Predicate("thirsty", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"old.HealthFanatic", new int[] {59,9,59,24},
			new GoalEvent('+',
				new Goal(
					new Predicate("time", new Term[] {
						new Variable(Type.INTEGER, "T",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"old.HealthFanatic", new int[] {59,23,62,5},
				new Statement[] {
					new SpecialBeliefUpdate(
						"old.HealthFanatic", new int[] {60,8,62,5},
						new Predicate("time", new Term[] {
							new Variable(Type.INTEGER, "T")
						})
					),
					new ModuleCall("C",
						"old.HealthFanatic", new int[] {61,8,61,32},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("It is: "),
								new Variable(Type.INTEGER, "T")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("old.HealthFanatic","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"old.HealthFanatic", new int[] {67,9,67,21},
			new BeliefEvent('+',
				new Predicate("thirsty", new Term[] {})
			),
			Predicate.TRUE,
			new Block(
				"old.HealthFanatic", new int[] {67,20,70,5},
				new Statement[] {
					new ModuleCall("C",
						"old.HealthFanatic", new int[] {68,8,68,33},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("I AM THIRSTY")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("old.HealthFanatic","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"old.HealthFanatic", new int[] {69,8,70,5},
						new Goal(
							new Predicate("hydrated", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"old.HealthFanatic", new int[] {72,9,72,77},
			new BeliefEvent('-',
				new Predicate("quantity", new Term[] {
					Primitive.newPrimitive("water"),
					new Variable(Type.INTEGER, "Q",false)
				})
			),
			new AND(
				new Predicate("reorder_level", new Term[] {
					Primitive.newPrimitive("water"),
					new Variable(Type.INTEGER, "L",false)
				}),
				new Comparison(">=",
					new Variable(Type.INTEGER, "L"),
					new Variable(Type.INTEGER, "Q")
				)
			),
			new Block(
				"old.HealthFanatic", new int[] {72,76,75,5},
				new Statement[] {
					new ModuleCall("C",
						"old.HealthFanatic", new int[] {73,8,73,34},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("REORDER WATER")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("old.HealthFanatic","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"old.HealthFanatic", new int[] {74,8,75,5},
						new Goal(
							new Predicate("quantity", new Term[] {
								Primitive.newPrimitive("water"),
								Primitive.newPrimitive(5)
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"old.HealthFanatic", new int[] {80,30,88,5},
			new GoalEvent('+',
				new Goal(
					new Predicate("hydrated", new Term[] {})
				)
			),
			new AND(
				new Predicate("quantity", new Term[] {
					Primitive.newPrimitive("water"),
					new Variable(Type.INTEGER, "Q",false)
				}),
				new AND(
					new Predicate("impact", new Term[] {
						Primitive.newPrimitive("water"),
						new Variable(Type.INTEGER, "I",false)
					}),
					new Predicate("thirst_level", new Term[] {
						new Variable(Type.INTEGER, "level",false)
					})
				)
			),
			new SynchronizedBlock(
				"old.HealthFanatic", new int[] {82,38,88,5},
				"thirst",
				new Block(
					"old.HealthFanatic", new int[] {82,38,88,5},
					new Statement[] {
						new BeliefUpdate('-',
							"old.HealthFanatic", new int[] {83,8,88,5},
							new Predicate("quantity", new Term[] {
								Primitive.newPrimitive("water"),
								new Variable(Type.INTEGER, "Q")
							})
						),
						new If(
							"old.HealthFanatic", new int[] {84,8,88,5},
							new Comparison(">",
								new Variable(Type.INTEGER, "Q"),
								Primitive.newPrimitive(1)
							),
							new BeliefUpdate('+',
								"old.HealthFanatic", new int[] {84,18,88,5},
								new Predicate("quantity", new Term[] {
									Primitive.newPrimitive("water"),
									Operator.newOperator('-',
										new Variable(Type.INTEGER, "Q"),
										Primitive.newPrimitive(1)
									)
								})
							)
						),
						new SpecialBeliefUpdate(
							"old.HealthFanatic", new int[] {85,8,88,5},
							new Predicate("thirst_level", new Term[] {
								Operator.newOperator('+',
									new Variable(Type.INTEGER, "level"),
									new Variable(Type.INTEGER, "I")
								)
							})
						),
						new ModuleCall("C",
							"old.HealthFanatic", new int[] {86,8,86,44},
							new Predicate("println", new Term[] {
								Primitive.newPrimitive("Hydrating with WATER...")
							}),
							new DefaultModuleCallAdaptor() {
								public boolean inline() {
									return true;
								}

								public boolean invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.Console) intention.getModule("old.HealthFanatic","C")).println(
										(java.lang.String) intention.evaluate(predicate.getTerm(0))
									);
								}
							}
						)
					}
				)
			)
		));
		addRule(new Rule(
			"old.HealthFanatic", new int[] {90,9,90,23},
			new GoalEvent('+',
				new Goal(
					new Predicate("hydrated", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"old.HealthFanatic", new int[] {90,22,92,5},
				new Statement[] {
					new ModuleCall("C",
						"old.HealthFanatic", new int[] {91,8,91,38},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("I NEED A DRINK!!!")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("old.HealthFanatic","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"old.HealthFanatic", new int[] {94,9,94,37},
			new GoalEvent('+',
				new Goal(
					new Predicate("quantity", new Term[] {
						Primitive.newPrimitive("water"),
						new Variable(Type.INTEGER, "Q",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"old.HealthFanatic", new int[] {94,36,96,5},
				new Statement[] {
					new ModuleCall("C",
						"old.HealthFanatic", new int[] {95,8,95,54},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Add water to the shopping list...")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("old.HealthFanatic","C")).println(
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
			new Predicate("thirst_level", new Term[] {
				Primitive.newPrimitive(20)
			})
		);
		agent.initialize(
			new Predicate("quantity", new Term[] {
				Primitive.newPrimitive("water"),
				Primitive.newPrimitive(4)
			})
		);
		agent.initialize(
			new Predicate("impact", new Term[] {
				Primitive.newPrimitive("water"),
				Primitive.newPrimitive(10)
			})
		);
		agent.initialize(
			new Predicate("reorder_level", new Term[] {
				Primitive.newPrimitive("water"),
				Primitive.newPrimitive(2)
			})
		);
		agent.initialize(
			new Predicate("time", new Term[] {
				Primitive.newPrimitive(0)
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("S",astra.lang.System.class,agent);
		fragment.addModule("C",astra.lang.Console.class,agent);
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
			astra.core.Agent agent = new HealthFanatic().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: HealthFanatic");
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
