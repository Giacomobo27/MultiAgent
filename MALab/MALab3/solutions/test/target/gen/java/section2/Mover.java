package section2;
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


public class Mover extends ASTRAClass {
	public Mover() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"section2.Mover", new int[] {26,9,26,53},
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
				"section2.Mover", new int[] {26,52,26,55},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"section2.Mover", new int[] {28,9,29,71},
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
				"section2.Mover", new int[] {29,70,32,5},
				new Statement[] {
					new SpecialBeliefUpdate(
						"section2.Mover", new int[] {30,8,32,5},
						new Predicate("current", new Term[] {
							new Variable(Type.STRING, "target")
						})
					),
					new ModuleCall("C",
						"section2.Mover", new int[] {31,8,31,40},
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
								return ((astra.lang.Console) intention.getModule("section2.Mover","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"section2.Mover", new int[] {34,9,36,41},
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
				"section2.Mover", new int[] {36,40,40,5},
				new Statement[] {
					new ModuleCall("C",
						"section2.Mover", new int[] {37,8,37,59},
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
								return ((astra.lang.Console) intention.getModule("section2.Mover","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"section2.Mover", new int[] {38,8,40,5},
						new Goal(
							new Predicate("current", new Term[] {
								new Variable(Type.STRING, "middle")
							})
						)
					),
					new Subgoal(
						"section2.Mover", new int[] {39,8,40,5},
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
			"section2.Mover", new int[] {42,9,44,78},
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
				"section2.Mover", new int[] {44,77,49,5},
				new Statement[] {
					new ModuleCall("C",
						"section2.Mover", new int[] {45,8,45,79},
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
								return ((astra.lang.Console) intention.getModule("section2.Mover","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"section2.Mover", new int[] {46,8,49,5},
						new Goal(
							new Predicate("current", new Term[] {
								new Variable(Type.STRING, "middle")
							})
						)
					),
					new Subgoal(
						"section2.Mover", new int[] {47,8,49,5},
						new Goal(
							new Predicate("current", new Term[] {
								new Variable(Type.STRING, "middle2")
							})
						)
					),
					new Subgoal(
						"section2.Mover", new int[] {48,8,49,5},
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
			"section2.Mover", new int[] {51,9,51,62},
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
				"section2.Mover", new int[] {51,61,53,5},
				new Statement[] {
					new ModuleCall("C",
						"section2.Mover", new int[] {52,8,52,44},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("COULD NOT FIND ROUTE...")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("section2.Mover","C")).println(
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
			astra.core.Agent agent = new Mover().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: Mover");
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
