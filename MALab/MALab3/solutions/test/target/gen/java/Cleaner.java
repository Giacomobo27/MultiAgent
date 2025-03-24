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


public class Cleaner extends ASTRAClass {
	public Cleaner() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"Cleaner", new int[] {37,9,37,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Cleaner", new int[] {37,27,39,5},
				new Statement[] {
					new Subgoal(
						"Cleaner", new int[] {38,8,39,5},
						new Goal(
							new Predicate("clock", new Term[] {
								Primitive.newPrimitive(0),
								Primitive.newPrimitive(0)
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Cleaner", new int[] {44,9,44,31},
			new GoalEvent('+',
				new Goal(
					new Predicate("clock", new Term[] {
						Primitive.newPrimitive(3),
						Primitive.newPrimitive(24)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Cleaner", new int[] {44,30,47,5},
				new Statement[] {
					new ModuleCall("C",
						"Cleaner", new int[] {45,8,45,41},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("SIMULATION FINISHED!")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Cleaner","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("S",
						"Cleaner", new int[] {46,8,46,16},
						new Predicate("exit", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Cleaner","S")).exit(
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Cleaner", new int[] {49,9,49,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("clock", new Term[] {
						new Variable(Type.INTEGER, "D",false),
						Primitive.newPrimitive(24)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Cleaner", new int[] {49,27,51,5},
				new Statement[] {
					new Subgoal(
						"Cleaner", new int[] {50,8,51,5},
						new Goal(
							new Predicate("clock", new Term[] {
								Operator.newOperator('+',
									new Variable(Type.INTEGER, "D"),
									Primitive.newPrimitive(1)
								),
								Primitive.newPrimitive(0)
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Cleaner", new int[] {53,9,53,32},
			new GoalEvent('+',
				new Goal(
					new Predicate("clock", new Term[] {
						new Variable(Type.INTEGER, "D",false),
						new Variable(Type.INTEGER, "H",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Cleaner", new int[] {53,31,58,5},
				new Statement[] {
					new SpecialBeliefUpdate(
						"Cleaner", new int[] {54,8,58,5},
						new Predicate("clock", new Term[] {
							new Variable(Type.INTEGER, "D"),
							new Variable(Type.INTEGER, "H")
						})
					),
					new ModuleCall("C",
						"Cleaner", new int[] {55,8,55,48},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Time: "),
								Operator.newOperator('+',
									new Variable(Type.INTEGER, "H"),
									Operator.newOperator('+',
										Primitive.newPrimitive(" [DAY="),
										Operator.newOperator('+',
											new Variable(Type.INTEGER, "D"),
											Primitive.newPrimitive("]")
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
								return ((astra.lang.Console) intention.getModule("Cleaner","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("S",
						"Cleaner", new int[] {56,8,56,22},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(1000)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Cleaner","S")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new SpawnGoal(
						"Cleaner", new int[] {57,8,58,5},
						new Goal(
							new Predicate("clock", new Term[] {
								new Variable(Type.INTEGER, "D"),
								Operator.newOperator('+',
									new Variable(Type.INTEGER, "H"),
									Primitive.newPrimitive(1)
								)
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Cleaner", new int[] {63,9,63,68},
			new BeliefEvent('+',
				new Predicate("clock", new Term[] {
					new Variable(Type.INTEGER, "D",false),
					new Variable(Type.INTEGER, "H",false)
				})
			),
			new Predicate("daily_schedule", new Term[] {
				new Variable(Type.INTEGER, "H"),
				new Variable(Type.STRING, "location",false)
			}),
			new Block(
				"Cleaner", new int[] {63,67,65,5},
				new Statement[] {
					new Subgoal(
						"Cleaner", new int[] {64,8,65,5},
						new Goal(
							new Predicate("current", new Term[] {
								new Variable(Type.STRING, "location")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Cleaner", new int[] {70,9,70,53},
			new GoalEvent('+',
				new Goal(
					new Predicate("current", new Term[] {
						new Variable(Type.STRING, "target",false)
					})
				)
			),
			new Predicate("current", new Term[] {
				new Variable(Type.STRING, "target")
			}),
			new Block(
				"Cleaner", new int[] {70,52,70,55},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Cleaner", new int[] {72,9,73,71},
			new GoalEvent('+',
				new Goal(
					new Predicate("current", new Term[] {
						new Variable(Type.STRING, "target",false)
					})
				)
			),
			new AND(
				new Predicate("current", new Term[] {
					new Variable(Type.STRING, "location",false)
				}),
				new Predicate("connected", new Term[] {
					new Variable(Type.STRING, "location"),
					new Variable(Type.STRING, "target")
				})
			),
			new Block(
				"Cleaner", new int[] {73,70,76,5},
				new Statement[] {
					new SpecialBeliefUpdate(
						"Cleaner", new int[] {74,8,76,5},
						new Predicate("current", new Term[] {
							new Variable(Type.STRING, "target")
						})
					),
					new ModuleCall("C",
						"Cleaner", new int[] {75,8,75,40},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Moved to: "),
								new Variable(Type.STRING, "target")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Cleaner","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Cleaner", new int[] {78,9,80,41},
			new GoalEvent('+',
				new Goal(
					new Predicate("current", new Term[] {
						new Variable(Type.STRING, "target",false)
					})
				)
			),
			new AND(
				new Predicate("current", new Term[] {
					new Variable(Type.STRING, "location",false)
				}),
				new AND(
					new Predicate("connected", new Term[] {
						new Variable(Type.STRING, "location"),
						new Variable(Type.STRING, "middle",false)
					}),
					new Predicate("connected", new Term[] {
						new Variable(Type.STRING, "middle"),
						new Variable(Type.STRING, "target")
					})
				)
			),
			new Block(
				"Cleaner", new int[] {80,40,84,5},
				new Statement[] {
					new ModuleCall("C",
						"Cleaner", new int[] {81,8,81,59},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("No direct route, moving via: "),
								new Variable(Type.STRING, "middle")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Cleaner","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Cleaner", new int[] {82,8,84,5},
						new Goal(
							new Predicate("current", new Term[] {
								new Variable(Type.STRING, "middle")
							})
						)
					),
					new Subgoal(
						"Cleaner", new int[] {83,8,84,5},
						new Goal(
							new Predicate("current", new Term[] {
								new Variable(Type.STRING, "target")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Cleaner", new int[] {86,9,88,78},
			new GoalEvent('+',
				new Goal(
					new Predicate("current", new Term[] {
						new Variable(Type.STRING, "target",false)
					})
				)
			),
			new AND(
				new Predicate("current", new Term[] {
					new Variable(Type.STRING, "location",false)
				}),
				new AND(
					new Predicate("connected", new Term[] {
						new Variable(Type.STRING, "location"),
						new Variable(Type.STRING, "middle",false)
					}),
					new AND(
						new Predicate("connected", new Term[] {
							new Variable(Type.STRING, "middle"),
							new Variable(Type.STRING, "middle2",false)
						}),
						new Predicate("connected", new Term[] {
							new Variable(Type.STRING, "middle2"),
							new Variable(Type.STRING, "target")
						})
					)
				)
			),
			new Block(
				"Cleaner", new int[] {88,77,93,5},
				new Statement[] {
					new ModuleCall("C",
						"Cleaner", new int[] {89,8,89,79},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("No direct route, moving via: "),
								Operator.newOperator('+',
									new Variable(Type.STRING, "middle"),
									Operator.newOperator('+',
										Primitive.newPrimitive(" and: "),
										new Variable(Type.STRING, "middle2")
									)
								)
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Cleaner","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Cleaner", new int[] {90,8,93,5},
						new Goal(
							new Predicate("current", new Term[] {
								new Variable(Type.STRING, "middle")
							})
						)
					),
					new Subgoal(
						"Cleaner", new int[] {91,8,93,5},
						new Goal(
							new Predicate("current", new Term[] {
								new Variable(Type.STRING, "middle2")
							})
						)
					),
					new Subgoal(
						"Cleaner", new int[] {92,8,93,5},
						new Goal(
							new Predicate("current", new Term[] {
								new Variable(Type.STRING, "target")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Cleaner", new int[] {95,9,95,62},
			new GoalEvent('+',
				new Goal(
					new Predicate("current", new Term[] {
						new Variable(Type.STRING, "target",false)
					})
				)
			),
			new Predicate("current", new Term[] {
				new Variable(Type.STRING, "location",false)
			}),
			new Block(
				"Cleaner", new int[] {95,61,97,5},
				new Statement[] {
					new ModuleCall("C",
						"Cleaner", new int[] {96,8,96,44},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("COULD NOT FIND ROUTE...")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Cleaner","C")).println(
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
				Primitive.newPrimitive("corridor")
			})
		);
		agent.initialize(
			new Predicate("location", new Term[] {
				Primitive.newPrimitive("bedroom")
			})
		);
		agent.initialize(
			new Predicate("location", new Term[] {
				Primitive.newPrimitive("lounge")
			})
		);
		agent.initialize(
			new Predicate("location", new Term[] {
				Primitive.newPrimitive("kitchen")
			})
		);
		agent.initialize(
			new Predicate("location", new Term[] {
				Primitive.newPrimitive("bathroom")
			})
		);
		agent.initialize(
			new Predicate("location", new Term[] {
				Primitive.newPrimitive("dining_room")
			})
		);
		agent.initialize(
			new Predicate("location", new Term[] {
				Primitive.newPrimitive("office")
			})
		);
		agent.initialize(
			new Predicate("connected", new Term[] {
				Primitive.newPrimitive("corridor"),
				Primitive.newPrimitive("bedroom")
			})
		);
		agent.initialize(
			new Predicate("connected", new Term[] {
				Primitive.newPrimitive("bedroom"),
				Primitive.newPrimitive("corridor")
			})
		);
		agent.initialize(
			new Predicate("connected", new Term[] {
				Primitive.newPrimitive("corridor"),
				Primitive.newPrimitive("lounge")
			})
		);
		agent.initialize(
			new Predicate("connected", new Term[] {
				Primitive.newPrimitive("lounge"),
				Primitive.newPrimitive("corridor")
			})
		);
		agent.initialize(
			new Predicate("connected", new Term[] {
				Primitive.newPrimitive("corridor"),
				Primitive.newPrimitive("bathroom")
			})
		);
		agent.initialize(
			new Predicate("connected", new Term[] {
				Primitive.newPrimitive("bathroom"),
				Primitive.newPrimitive("corridor")
			})
		);
		agent.initialize(
			new Predicate("connected", new Term[] {
				Primitive.newPrimitive("corridor"),
				Primitive.newPrimitive("office")
			})
		);
		agent.initialize(
			new Predicate("connected", new Term[] {
				Primitive.newPrimitive("office"),
				Primitive.newPrimitive("corridor")
			})
		);
		agent.initialize(
			new Predicate("connected", new Term[] {
				Primitive.newPrimitive("kitchen"),
				Primitive.newPrimitive("lounge")
			})
		);
		agent.initialize(
			new Predicate("connected", new Term[] {
				Primitive.newPrimitive("lounge"),
				Primitive.newPrimitive("kitchen")
			})
		);
		agent.initialize(
			new Predicate("connected", new Term[] {
				Primitive.newPrimitive("dining_room"),
				Primitive.newPrimitive("lounge")
			})
		);
		agent.initialize(
			new Predicate("connected", new Term[] {
				Primitive.newPrimitive("lounge"),
				Primitive.newPrimitive("dining_room")
			})
		);
		agent.initialize(
			new Predicate("current", new Term[] {
				Primitive.newPrimitive("bedroom")
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("C",astra.lang.Console.class,agent);
		fragment.addModule("S",astra.lang.System.class,agent);
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
			astra.core.Agent agent = new Cleaner().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: Cleaner");
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
