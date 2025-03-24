package section3;
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


public class Building extends ASTRAClass {
	public Building() {
		setParents(new Class[] {section2.Clock.class});
		addRule(new Rule(
			"section3.Building", new int[] {38,9,38,54},
			new BeliefEvent('+',
				new Predicate("clock", new Term[] {
					new Variable(Type.INTEGER, "D",false),
					new Variable(Type.INTEGER, "H",false)
				})
			),
			new Predicate("hour_light", new Term[] {
				new Variable(Type.INTEGER, "H"),
				new Variable(Type.INTEGER, "L",false)
			}),
			new Block(
				"section3.Building", new int[] {38,53,47,5},
				new Statement[] {
					new ModuleCall("C",
						"section3.Building", new int[] {39,8,39,41},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Light Level is: "),
								new Variable(Type.INTEGER, "L")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("section3.Building","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new SpecialBeliefUpdate(
						"section3.Building", new int[] {40,8,47,5},
						new Predicate("light_level", new Term[] {
							new Variable(Type.INTEGER, "L")
						})
					),
					new ForEach(
						"section3.Building", new int[] {43,8,47,5},
						new Predicate("daily_activity", new Term[] {
							new Variable(Type.INTEGER, "H"),
							new Variable(Type.STRING, "Sw",false),
							new Variable(Type.STRING, "St",false)
						}),
						new Block(
							"section3.Building", new int[] {43,57,46,9},
							new Statement[] {
								new ModuleCall("C",
									"section3.Building", new int[] {44,12,44,72},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("User Action: Switch "),
											Operator.newOperator('+',
												new Variable(Type.STRING, "Sw"),
												Operator.newOperator('+',
													Primitive.newPrimitive(" is turned: "),
													new Variable(Type.STRING, "St")
												)
											)
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("section3.Building","C")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Subgoal(
									"section3.Building", new int[] {45,12,46,9},
									new Goal(
										new Predicate("switch", new Term[] {
											new Variable(Type.STRING, "Sw"),
											new Variable(Type.STRING, "St")
										})
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"section3.Building", new int[] {53,9,53,63},
			new BeliefEvent('+',
				new Predicate("light_level", new Term[] {
					new Variable(Type.INTEGER, "L",false)
				})
			),
			new AND(
				new Predicate("light_threshold", new Term[] {
					new Variable(Type.INTEGER, "T",false)
				}),
				new Comparison(">",
					new Variable(Type.INTEGER, "L"),
					new Variable(Type.INTEGER, "T")
				)
			),
			new Block(
				"section3.Building", new int[] {53,62,57,5},
				new Statement[] {
					new ForEach(
						"section3.Building", new int[] {54,8,57,5},
						new Predicate("light", new Term[] {
							new Variable(Type.STRING, "Lt",false),
							Primitive.newPrimitive("on")
						}),
						new Block(
							"section3.Building", new int[] {54,40,56,9},
							new Statement[] {
								new Subgoal(
									"section3.Building", new int[] {55,12,56,9},
									new Goal(
										new Predicate("light", new Term[] {
											new Variable(Type.STRING, "Lt"),
											Primitive.newPrimitive("off")
										})
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"section3.Building", new int[] {64,9,64,30},
			new BeliefEvent('+',
				new Predicate("light_level", new Term[] {
					new Variable(Type.INTEGER, "L",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"section3.Building", new int[] {64,29,68,5},
				new Statement[] {
					new ForEach(
						"section3.Building", new int[] {65,8,68,5},
						new AND(
							new Predicate("switch", new Term[] {
								new Variable(Type.STRING, "S",false),
								Primitive.newPrimitive("on")
							}),
							new AND(
								new Predicate("connected", new Term[] {
									new Variable(Type.STRING, "S"),
									new Variable(Type.STRING, "Lt",false)
								}),
								new Predicate("light", new Term[] {
									new Variable(Type.STRING, "Lt"),
									Primitive.newPrimitive("off")
								})
							)
						),
						new Block(
							"section3.Building", new int[] {65,85,67,9},
							new Statement[] {
								new Subgoal(
									"section3.Building", new int[] {66,12,67,9},
									new Goal(
										new Predicate("light", new Term[] {
											new Variable(Type.STRING, "Lt"),
											Primitive.newPrimitive("on")
										})
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"section3.Building", new int[] {70,9,70,62},
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
				"section3.Building", new int[] {70,61,70,64},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"section3.Building", new int[] {71,9,72,64},
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
				"section3.Building", new int[] {72,63,75,5},
				new Statement[] {
					new BeliefUpdate('-',
						"section3.Building", new int[] {73,8,75,5},
						new Predicate("switch", new Term[] {
							new Variable(Type.STRING, "S"),
							new Variable(Type.STRING, "from")
						})
					),
					new BeliefUpdate('+',
						"section3.Building", new int[] {74,8,75,5},
						new Predicate("switch", new Term[] {
							new Variable(Type.STRING, "S"),
							new Variable(Type.STRING, "state")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"section3.Building", new int[] {77,16,81,5},
			new BeliefEvent('+',
				new Predicate("switch", new Term[] {
					new Variable(Type.STRING, "S",false),
					new Variable(Type.STRING, "state",false)
				})
			),
			Predicate.TRUE,
			new SynchronizedBlock(
				"section3.Building", new int[] {77,48,81,5},
				"synchronized",
				new Block(
					"section3.Building", new int[] {77,48,81,5},
					new Statement[] {
						new ForEach(
							"section3.Building", new int[] {78,8,81,5},
							new Predicate("connected", new Term[] {
								new Variable(Type.STRING, "S"),
								new Variable(Type.STRING, "L",false)
							}),
							new Block(
								"section3.Building", new int[] {78,40,80,9},
								new Statement[] {
									new Subgoal(
										"section3.Building", new int[] {79,12,80,9},
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
			"section3.Building", new int[] {89,9,89,90},
			new GoalEvent('+',
				new Goal(
					new Predicate("light", new Term[] {
						new Variable(Type.STRING, "L",false),
						Primitive.newPrimitive("on")
					})
				)
			),
			new AND(
				new Predicate("light_level", new Term[] {
					new Variable(Type.INTEGER, "Lv",false)
				}),
				new AND(
					new Predicate("light_threshold", new Term[] {
						new Variable(Type.INTEGER, "T",false)
					}),
					new Comparison(">",
						new Variable(Type.INTEGER, "Lv"),
						new Variable(Type.INTEGER, "T")
					)
				)
			),
			new Block(
				"section3.Building", new int[] {89,89,91,5},
				new Statement[] {
					new ModuleCall("C",
						"section3.Building", new int[] {90,8,90,98},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Light activation blocked because light level: "),
								Operator.newOperator('+',
									new Variable(Type.STRING, "L"),
									Operator.newOperator('+',
										Primitive.newPrimitive(" is greater than: "),
										new Variable(Type.INTEGER, "T")
									)
								)
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("section3.Building","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"section3.Building", new int[] {93,9,93,60},
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
				"section3.Building", new int[] {93,59,93,62},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"section3.Building", new int[] {95,9,96,63},
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
				"section3.Building", new int[] {96,62,99,5},
				new Statement[] {
					new BeliefUpdate('-',
						"section3.Building", new int[] {97,8,99,5},
						new Predicate("light", new Term[] {
							new Variable(Type.STRING, "L"),
							new Variable(Type.STRING, "from")
						})
					),
					new BeliefUpdate('+',
						"section3.Building", new int[] {98,8,99,5},
						new Predicate("light", new Term[] {
							new Variable(Type.STRING, "L"),
							new Variable(Type.STRING, "state")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"section3.Building", new int[] {101,9,101,41},
			new BeliefEvent('+',
				new Predicate("light", new Term[] {
					new Variable(Type.STRING, "L",false),
					new Variable(Type.STRING, "state",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"section3.Building", new int[] {101,40,103,5},
				new Statement[] {
					new ModuleCall("C",
						"section3.Building", new int[] {102,8,102,58},
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
								return ((astra.lang.Console) intention.getModule("section3.Building","C")).println(
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
			new Predicate("connected", new Term[] {
				Primitive.newPrimitive("s1"),
				Primitive.newPrimitive("l1")
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
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(0),
				Primitive.newPrimitive(1)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(1),
				Primitive.newPrimitive(1)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(2),
				Primitive.newPrimitive(1)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(3),
				Primitive.newPrimitive(1)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(4),
				Primitive.newPrimitive(1)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(5),
				Primitive.newPrimitive(1)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(6),
				Primitive.newPrimitive(100)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(7),
				Primitive.newPrimitive(250)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(8),
				Primitive.newPrimitive(400)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(9),
				Primitive.newPrimitive(800)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(10),
				Primitive.newPrimitive(1000)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(11),
				Primitive.newPrimitive(1000)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(12),
				Primitive.newPrimitive(1000)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(13),
				Primitive.newPrimitive(1000)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(14),
				Primitive.newPrimitive(1000)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(15),
				Primitive.newPrimitive(800)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(16),
				Primitive.newPrimitive(700)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(17),
				Primitive.newPrimitive(600)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(18),
				Primitive.newPrimitive(600)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(19),
				Primitive.newPrimitive(400)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(20),
				Primitive.newPrimitive(100)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(21),
				Primitive.newPrimitive(100)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(22),
				Primitive.newPrimitive(1)
			})
		);
		agent.initialize(
			new Predicate("hour_light", new Term[] {
				Primitive.newPrimitive(23),
				Primitive.newPrimitive(1)
			})
		);
		agent.initialize(
			new Predicate("light_threshold", new Term[] {
				Primitive.newPrimitive(750)
			})
		);
		agent.initialize(
			new Predicate("daily_activity", new Term[] {
				Primitive.newPrimitive(9),
				Primitive.newPrimitive("s1"),
				Primitive.newPrimitive("on")
			})
		);
		agent.initialize(
			new Predicate("daily_activity", new Term[] {
				Primitive.newPrimitive(17),
				Primitive.newPrimitive("s1"),
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
			astra.core.Agent agent = new Building().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: Building");
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
