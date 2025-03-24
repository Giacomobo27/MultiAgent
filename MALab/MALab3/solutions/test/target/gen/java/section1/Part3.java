package section1;
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


public class Part3 extends ASTRAClass {
	public Part3() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"section1.Part3", new int[] {19,9,19,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"section1.Part3", new int[] {19,27,21,5},
				new Statement[] {
					new Subgoal(
						"section1.Part3", new int[] {20,8,21,5},
						new Goal(
							new Predicate("flashed", new Term[] {
								Primitive.newPrimitive("l1"),
								Primitive.newPrimitive(10)
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"section1.Part3", new int[] {23,9,23,36},
			new GoalEvent('+',
				new Goal(
					new Predicate("flashed", new Term[] {
						new Variable(Type.STRING, "light",false),
						Primitive.newPrimitive(0)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"section1.Part3", new int[] {23,35,23,38},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"section1.Part3", new int[] {25,9,26,72},
			new GoalEvent('+',
				new Goal(
					new Predicate("flashed", new Term[] {
						new Variable(Type.STRING, "light",false),
						new Variable(Type.INTEGER, "times",false)
					})
				)
			),
			new AND(
				new Predicate("connected", new Term[] {
					new Variable(Type.STRING, "switch",false),
					new Variable(Type.STRING, "light")
				}),
				new Predicate("flashed", new Term[] {
					new Variable(Type.STRING, "light"),
					new Variable(Type.INTEGER, "T",false)
				})
			),
			new Block(
				"section1.Part3", new int[] {26,71,36,5},
				new Statement[] {
					new Subgoal(
						"section1.Part3", new int[] {27,8,36,5},
						new Goal(
							new Predicate("switch", new Term[] {
								new Variable(Type.STRING, "switch"),
								Primitive.newPrimitive("off")
							})
						)
					),
					new ModuleCall("S",
						"section1.Part3", new int[] {28,8,28,20},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(1000)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("section1.Part3","S")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"section1.Part3", new int[] {29,8,36,5},
						new Goal(
							new Predicate("switch", new Term[] {
								new Variable(Type.STRING, "switch"),
								Primitive.newPrimitive("on")
							})
						)
					),
					new ModuleCall("S",
						"section1.Part3", new int[] {30,8,30,20},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(1000)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("section1.Part3","S")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"section1.Part3", new int[] {31,8,36,5},
						new Goal(
							new Predicate("switch", new Term[] {
								new Variable(Type.STRING, "switch"),
								Primitive.newPrimitive("off")
							})
						)
					),
					new BeliefUpdate('-',
						"section1.Part3", new int[] {33,8,36,5},
						new Predicate("flashed", new Term[] {
							new Variable(Type.STRING, "light"),
							new Variable(Type.INTEGER, "T")
						})
					),
					new BeliefUpdate('+',
						"section1.Part3", new int[] {34,8,36,5},
						new Predicate("flashed", new Term[] {
							new Variable(Type.STRING, "light"),
							Operator.newOperator('+',
								new Variable(Type.INTEGER, "T"),
								Primitive.newPrimitive(1)
							)
						})
					),
					new Subgoal(
						"section1.Part3", new int[] {35,8,36,5},
						new Goal(
							new Predicate("flashed", new Term[] {
								new Variable(Type.STRING, "light"),
								Operator.newOperator('-',
									new Variable(Type.INTEGER, "times"),
									Primitive.newPrimitive(1)
								)
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"section1.Part3", new int[] {38,9,38,45},
			new GoalEvent('+',
				new Goal(
					new Predicate("flashed", new Term[] {
						new Variable(Type.STRING, "light",false),
						new Variable(Type.INTEGER, "times",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"section1.Part3", new int[] {38,44,41,5},
				new Statement[] {
					new BeliefUpdate('+',
						"section1.Part3", new int[] {39,8,41,5},
						new Predicate("flashed", new Term[] {
							new Variable(Type.STRING, "light"),
							Primitive.newPrimitive(0)
						})
					),
					new Subgoal(
						"section1.Part3", new int[] {40,8,41,5},
						new Goal(
							new Predicate("flashed", new Term[] {
								new Variable(Type.STRING, "light"),
								new Variable(Type.INTEGER, "times")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"section1.Part3", new int[] {43,9,43,62},
			new GoalEvent('+',
				new Goal(
					new Predicate("switch", new Term[] {
						new Variable(Type.STRING, "S",false),
						new Variable(Type.STRING, "state",false)
					})
				)
			),
			new Predicate("switch", new Term[] {
				new Variable(Type.STRING, "S"),
				new Variable(Type.STRING, "state")
			}),
			new Block(
				"section1.Part3", new int[] {43,61,43,64},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"section1.Part3", new int[] {44,9,45,64},
			new GoalEvent('+',
				new Goal(
					new Predicate("switch", new Term[] {
						new Variable(Type.STRING, "S",false),
						new Variable(Type.STRING, "state",false)
					})
				)
			),
			new AND(
				new Predicate("transition", new Term[] {
					new Variable(Type.STRING, "from",false),
					new Variable(Type.STRING, "state")
				}),
				new Predicate("switch", new Term[] {
					new Variable(Type.STRING, "S"),
					new Variable(Type.STRING, "from")
				})
			),
			new Block(
				"section1.Part3", new int[] {45,63,48,5},
				new Statement[] {
					new BeliefUpdate('-',
						"section1.Part3", new int[] {46,8,48,5},
						new Predicate("switch", new Term[] {
							new Variable(Type.STRING, "S"),
							new Variable(Type.STRING, "from")
						})
					),
					new BeliefUpdate('+',
						"section1.Part3", new int[] {47,8,48,5},
						new Predicate("switch", new Term[] {
							new Variable(Type.STRING, "S"),
							new Variable(Type.STRING, "state")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"section1.Part3", new int[] {50,16,54,5},
			new BeliefEvent('+',
				new Predicate("switch", new Term[] {
					new Variable(Type.STRING, "S",false),
					new Variable(Type.STRING, "state",false)
				})
			),
			Predicate.TRUE,
			new SynchronizedBlock(
				"section1.Part3", new int[] {50,48,54,5},
				"synchronized",
				new Block(
					"section1.Part3", new int[] {50,48,54,5},
					new Statement[] {
						new ForEach(
							"section1.Part3", new int[] {51,8,54,5},
							new Predicate("connected", new Term[] {
								new Variable(Type.STRING, "S"),
								new Variable(Type.STRING, "L",false)
							}),
							new Block(
								"section1.Part3", new int[] {51,40,53,9},
								new Statement[] {
									new Subgoal(
										"section1.Part3", new int[] {52,12,53,9},
										new Goal(
											new Predicate("light", new Term[] {
												new Variable(Type.STRING, "L"),
												new Variable(Type.STRING, "state")
											})
										)
									)
								}
							)
						)
					}
				)
			)
		));
		addRule(new Rule(
			"section1.Part3", new int[] {56,9,56,60},
			new GoalEvent('+',
				new Goal(
					new Predicate("light", new Term[] {
						new Variable(Type.STRING, "L",false),
						new Variable(Type.STRING, "state",false)
					})
				)
			),
			new Predicate("light", new Term[] {
				new Variable(Type.STRING, "L"),
				new Variable(Type.STRING, "state")
			}),
			new Block(
				"section1.Part3", new int[] {56,59,56,62},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"section1.Part3", new int[] {58,9,59,63},
			new GoalEvent('+',
				new Goal(
					new Predicate("light", new Term[] {
						new Variable(Type.STRING, "L",false),
						new Variable(Type.STRING, "state",false)
					})
				)
			),
			new AND(
				new Predicate("transition", new Term[] {
					new Variable(Type.STRING, "from",false),
					new Variable(Type.STRING, "state")
				}),
				new Predicate("light", new Term[] {
					new Variable(Type.STRING, "L"),
					new Variable(Type.STRING, "from")
				})
			),
			new Block(
				"section1.Part3", new int[] {59,62,62,5},
				new Statement[] {
					new BeliefUpdate('-',
						"section1.Part3", new int[] {60,8,62,5},
						new Predicate("light", new Term[] {
							new Variable(Type.STRING, "L"),
							new Variable(Type.STRING, "from")
						})
					),
					new BeliefUpdate('+',
						"section1.Part3", new int[] {61,8,62,5},
						new Predicate("light", new Term[] {
							new Variable(Type.STRING, "L"),
							new Variable(Type.STRING, "state")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"section1.Part3", new int[] {64,9,64,41},
			new BeliefEvent('+',
				new Predicate("light", new Term[] {
					new Variable(Type.STRING, "L",false),
					new Variable(Type.STRING, "state",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"section1.Part3", new int[] {64,40,66,5},
				new Statement[] {
					new ModuleCall("C",
						"section1.Part3", new int[] {65,8,65,58},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Light: "),
								Operator.newOperator('+',
									new Variable(Type.STRING, "L"),
									Operator.newOperator('+',
										Primitive.newPrimitive(" is in state: "),
										new Variable(Type.STRING, "state")
									)
								)
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("section1.Part3","C")).println(
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
			new Predicate("switch", new Term[] {
				Primitive.newPrimitive("s1"),
				Primitive.newPrimitive("off")
			})
		);
		agent.initialize(
			new Predicate("light", new Term[] {
				Primitive.newPrimitive("l1"),
				Primitive.newPrimitive("on")
			})
		);
		agent.initialize(
			new Predicate("light", new Term[] {
				Primitive.newPrimitive("l2"),
				Primitive.newPrimitive("off")
			})
		);
		agent.initialize(
			new Predicate("connected", new Term[] {
				Primitive.newPrimitive("s1"),
				Primitive.newPrimitive("l1")
			})
		);
		agent.initialize(
			new Predicate("connected", new Term[] {
				Primitive.newPrimitive("s1"),
				Primitive.newPrimitive("l2")
			})
		);
		agent.initialize(
			new Predicate("transition", new Term[] {
				Primitive.newPrimitive("off"),
				Primitive.newPrimitive("on")
			})
		);
		agent.initialize(
			new Predicate("transition", new Term[] {
				Primitive.newPrimitive("on"),
				Primitive.newPrimitive("off")
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
			astra.core.Agent agent = new Part3().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: Part3");
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
