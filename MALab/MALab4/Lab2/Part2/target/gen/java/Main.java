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
		addRule(new Rule(
			"Main", new int[] {6,9,6,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {6,27,33,5},
				new Statement[] {
					new ModuleCall("ei",
						"Main", new int[] {7,8,7,52},
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
						"Main", new int[] {8,8,8,17},
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
						"Main", new int[] {9,8,9,18},
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
						"Main", new int[] {10,8,10,26},
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
						"Main", new int[] {11,8,11,64},
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
					),
					new ModuleCall("ei",
						"Main", new int[] {16,8,16,22},
						new Predicate("pickup", new Term[] {
							Primitive.newPrimitive("d")
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
						"Main", new int[] {17,8,33,5},
						new ModuleFormula("ei",
							new Predicate("holding", new Term[] {
								Primitive.newPrimitive("d")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new ModuleCall("ei",
						"Main", new int[] {18,8,18,28},
						new Predicate("putdown", new Term[] {
							Primitive.newPrimitive("d"),
							Primitive.newPrimitive("c")
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
						"Main", new int[] {19,8,33,5},
						new ModuleFormula("ei",
							new Predicate("on", new Term[] {
								Primitive.newPrimitive("d"),
								Primitive.newPrimitive("c")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new ModuleCall("ei",
						"Main", new int[] {21,8,21,22},
						new Predicate("pickup", new Term[] {
							Primitive.newPrimitive("a")
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
						"Main", new int[] {22,8,33,5},
						new ModuleFormula("ei",
							new Predicate("holding", new Term[] {
								Primitive.newPrimitive("a")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new ModuleCall("ei",
						"Main", new int[] {23,8,23,28},
						new Predicate("putdown", new Term[] {
							Primitive.newPrimitive("a"),
							Primitive.newPrimitive("b")
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
						"Main", new int[] {24,8,33,5},
						new ModuleFormula("ei",
							new Predicate("on", new Term[] {
								Primitive.newPrimitive("a"),
								Primitive.newPrimitive("b")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new ModuleCall("C",
						"Main", new int[] {25,8,25,32},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("TOWER BUILT")
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
					new ModuleCall("S",
						"Main", new int[] {26,8,26,20},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(2000)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Main","S")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("ei",
						"Main", new int[] {27,8,27,22},
						new Predicate("pickup", new Term[] {
							Primitive.newPrimitive("a")
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
						"Main", new int[] {28,8,33,5},
						new ModuleFormula("ei",
							new Predicate("holding", new Term[] {
								Primitive.newPrimitive("a")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new ModuleCall("ei",
						"Main", new int[] {29,8,29,31},
						new Predicate("putdown", new Term[] {
							Primitive.newPrimitive("a"),
							Primitive.newPrimitive("table")
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
						"Main", new int[] {30,8,33,5},
						new ModuleFormula("ei",
							new Predicate("on", new Term[] {
								Primitive.newPrimitive("a"),
								Primitive.newPrimitive("table")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new ModuleCall("C",
						"Main", new int[] {31,8,31,29},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("FINISHED")
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
			"Main", new int[] {34,9,34,33},
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
				"Main", new int[] {34,32,36,5},
				new Statement[] {
					new ModuleCall("C",
						"Main", new int[] {35,8,35,36},
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
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {38,9,38,40},
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
				"Main", new int[] {38,39,40,5},
				new Statement[] {
					new ModuleCall("C",
						"Main", new int[] {39,8,39,36},
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
			"Main", new int[] {42,9,42,30},
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
				"Main", new int[] {42,29,44,5},
				new Statement[] {
					new ModuleCall("C",
						"Main", new int[] {43,8,43,49},
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
			"Main", new int[] {46,9,46,35},
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
				"Main", new int[] {46,34,48,5},
				new Statement[] {
					new ModuleCall("C",
						"Main", new int[] {47,8,47,52},
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
			"Main", new int[] {49,9,49,45},
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
				"Main", new int[] {49,44,51,5},
				new Statement[] {
					new ModuleCall("C",
						"Main", new int[] {50,8,50,50},
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
