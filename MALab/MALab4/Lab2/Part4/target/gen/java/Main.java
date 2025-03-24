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


public class Main extends ASTRAClass {
	public Main() {
		setParents(new Class[] {astra.lang.Agent.class});
		addInference(new Inference(
			new Predicate("free", new Term[] {
				new Variable(Type.STRING, "A",false)
			}),
			new NOT(
				new ModuleFormula("ei",
					new Predicate("on", new Term[] {
						new Variable(Type.STRING, "B",false),
						new Variable(Type.STRING, "A")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				)
			)
		));
		addInference(new Inference(
			new Predicate("tower", new Term[] {
				new Variable(Type.STRING, "A",false),
				new Variable(Type.STRING, "B",false),
				new Variable(Type.STRING, "C",false)
			}),
			new AND(
				new ModuleFormula("ei",
					new Predicate("on", new Term[] {
						new Variable(Type.STRING, "A"),
						new Variable(Type.STRING, "B")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				),
				new AND(
					new ModuleFormula("ei",
						new Predicate("on", new Term[] {
							new Variable(Type.STRING, "B"),
							new Variable(Type.STRING, "C")
						}),
						new ModuleFormulaAdaptor() {
							public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
								return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
							}
						}
					),
					new ModuleFormula("ei",
						new Predicate("on", new Term[] {
							new Variable(Type.STRING, "C"),
							new Variable(Type.STRING, "â??tableâ??",false)
						}),
						new ModuleFormulaAdaptor() {
							public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
								return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
							}
						}
					)
				)
			)
		));
		addRule(new Rule(
			"Main", new int[] {14,9,14,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {14,27,25,5},
				new Statement[] {
					new ModuleCall("ei",
						"Main", new int[] {15,8,15,52},
						new Predicate("launch", new Term[] {
							Primitive.newPrimitive("hw"),
							Primitive.newPrimitive("dependency/tower-1.3.0.jar")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).launch(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("ei",
						"Main", new int[] {16,8,16,17},
						new Predicate("init", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).init(
								);
							}
						}
					),
					new ModuleCall("ei",
						"Main", new int[] {17,8,17,18},
						new Predicate("start", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).start(
								);
							}
						}
					),
					new ModuleCall("ei",
						"Main", new int[] {18,8,18,26},
						new Predicate("link", new Term[] {
							Primitive.newPrimitive("gripper")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).link(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("C",
						"Main", new int[] {19,8,19,64},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Press New Block until block d is created...")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {27,9,27,33},
			new ModuleEvent("ei",
				"$eis",
				new Predicate("event", new Term[] {
					new Funct("block", new Term[] {
						Primitive.newPrimitive("d")
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.EIS) agent.getModule("Main","ei")).event(
							"+",
							predicate.getTerm(0)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {27,32,31,5},
				new Statement[] {
					new ModuleCall("C",
						"Main", new int[] {28,8,28,36},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("You did it! new")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Main", new int[] {29,8,31,5},
						new Goal(
							new Predicate("tower", new Term[] {
								Primitive.newPrimitive("a"),
								Primitive.newPrimitive("b"),
								Primitive.newPrimitive("c")
							})
						)
					),
					new Subgoal(
						"Main", new int[] {30,8,31,5},
						new Goal(
							new Predicate("tower", new Term[] {
								Primitive.newPrimitive("d"),
								Primitive.newPrimitive("c"),
								Primitive.newPrimitive("b")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {35,9,35,48},
			new GoalEvent('+',
				new Goal(
					new Predicate("tower", new Term[] {
						new Variable(Type.STRING, "A",false),
						new Variable(Type.STRING, "B",false),
						new Variable(Type.STRING, "C",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {35,47,39,5},
				new Statement[] {
					new Subgoal(
						"Main", new int[] {36,8,39,5},
						new Goal(
							new Predicate("on", new Term[] {
								new Variable(Type.STRING, "C"),
								Primitive.newPrimitive("table")
							})
						)
					),
					new Subgoal(
						"Main", new int[] {37,8,39,5},
						new Goal(
							new Predicate("on", new Term[] {
								new Variable(Type.STRING, "B"),
								new Variable(Type.STRING, "C")
							})
						)
					),
					new Subgoal(
						"Main", new int[] {38,8,39,5},
						new Goal(
							new Predicate("on", new Term[] {
								new Variable(Type.STRING, "A"),
								new Variable(Type.STRING, "B")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {41,9,41,49},
			new GoalEvent('+',
				new Goal(
					new Predicate("on", new Term[] {
						new Variable(Type.STRING, "A",false),
						new Variable(Type.STRING, "B",false)
					})
				)
			),
			new ModuleFormula("ei",
				new Predicate("on", new Term[] {
					new Variable(Type.STRING, "A"),
					new Variable(Type.STRING, "B")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"Main", new int[] {41,48,41,50},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {43,9,43,61},
			new GoalEvent('+',
				new Goal(
					new Predicate("on", new Term[] {
						new Variable(Type.STRING, "A",false),
						new Variable(Type.STRING, "B",false)
					})
				)
			),
			new AND(
				new ModuleFormula("ei",
					new Predicate("holding", new Term[] {
						new Variable(Type.STRING, "A")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				),
				new Predicate("free", new Term[] {
					new Variable(Type.STRING, "B")
				})
			),
			new Block(
				"Main", new int[] {43,60,46,5},
				new Statement[] {
					new ModuleCall("ei",
						"Main", new int[] {44,8,44,24},
						new Predicate("putdown", new Term[] {
							new Variable(Type.STRING, "A"),
							new Variable(Type.STRING, "B")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Wait(
						"Main", new int[] {45,8,46,5},
						new ModuleFormula("ei",
							new Predicate("on", new Term[] {
								new Variable(Type.STRING, "A"),
								new Variable(Type.STRING, "B")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {48,9,48,46},
			new GoalEvent('+',
				new Goal(
					new Predicate("on", new Term[] {
						new Variable(Type.STRING, "A",false),
						new Variable(Type.STRING, "B",false)
					})
				)
			),
			new NOT(
				new Predicate("free", new Term[] {
					new Variable(Type.STRING, "B")
				})
			),
			new Block(
				"Main", new int[] {48,45,51,5},
				new Statement[] {
					new Subgoal(
						"Main", new int[] {49,8,51,5},
						new Goal(
							new Predicate("free", new Term[] {
								new Variable(Type.STRING, "B")
							})
						)
					),
					new Subgoal(
						"Main", new int[] {50,8,51,5},
						new Goal(
							new Predicate("on", new Term[] {
								new Variable(Type.STRING, "A"),
								new Variable(Type.STRING, "B")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {52,9,52,52},
			new GoalEvent('+',
				new Goal(
					new Predicate("on", new Term[] {
						new Variable(Type.STRING, "A",false),
						new Variable(Type.STRING, "B",false)
					})
				)
			),
			new NOT(
				new ModuleFormula("ei",
					new Predicate("holding", new Term[] {
						new Variable(Type.STRING, "A")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				)
			),
			new Block(
				"Main", new int[] {52,51,55,5},
				new Statement[] {
					new Subgoal(
						"Main", new int[] {53,8,55,5},
						new Goal(
							new Predicate("holding", new Term[] {
								new Variable(Type.STRING, "A")
							})
						)
					),
					new Subgoal(
						"Main", new int[] {54,8,55,5},
						new Goal(
							new Predicate("on", new Term[] {
								new Variable(Type.STRING, "A"),
								new Variable(Type.STRING, "B")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {60,9,60,40},
			new ModuleEvent("ei",
				"$eis",
				new Predicate("event", new Term[] {
					new Funct("holding", new Term[] {
						new Variable(Type.STRING, "Y",false)
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.EIS) agent.getModule("Main","ei")).event(
							"+",
							predicate.getTerm(0)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {60,39,62,5},
				new Statement[] {
					new ModuleCall("C",
						"Main", new int[] {61,8,61,36},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Picked up: "),
								new Variable(Type.STRING, "Y")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {64,9,64,30},
			new ModuleEvent("ei",
				"$eis",
				new Predicate("event", new Term[] {
					new Variable(Type.FUNCTION, "Y",false)
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.EIS) agent.getModule("Main","ei")).event(
							"+",
							predicate.getTerm(0)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {64,29,66,5},
				new Statement[] {
					new ModuleCall("C",
						"Main", new int[] {65,8,65,49},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Handling belief update: "),
								new Variable(Type.FUNCTION, "Y")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {68,9,68,35},
			new ModuleEvent("ei",
				"$eis",
				new Predicate("event", new Term[] {
					new Variable(Type.FUNCTION, "belief",false)
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.EIS) agent.getModule("Main","ei")).event(
							"+",
							predicate.getTerm(0)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {68,34,70,5},
				new Statement[] {
					new ModuleCall("C",
						"Main", new int[] {69,8,69,52},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("New Perception Event: "),
								new Variable(Type.FUNCTION, "belief")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {71,9,71,45},
			new ModuleEvent("ei",
				"$eis",
				new Predicate("event", new Term[] {
					new Funct("on", new Term[] {
						new Variable(Type.STRING, "A",false),
						new Variable(Type.STRING, "B",false)
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.EIS) agent.getModule("Main","ei")).event(
							"+",
							predicate.getTerm(0)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {71,44,73,5},
				new Statement[] {
					new ModuleCall("C",
						"Main", new int[] {72,8,72,50},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								new Variable(Type.STRING, "A"),
								Operator.newOperator('+',
									Primitive.newPrimitive(" has been placed on: "),
									new Variable(Type.STRING, "B")
								)
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","C")).println(
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
		agent.addSensorAdaptor(new SensorAdaptor() {
			public void sense(astra.core.Agent agent) {
				((astra.lang.EIS) agent.getModule("Main","ei")).sense();
			}
		});

	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("ei",astra.lang.EIS.class,agent);
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
