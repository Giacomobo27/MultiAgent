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


public class VacBot extends ASTRAClass {
	public VacBot() {
		setParents(new Class[] {astra.lang.Agent.class});
		addInference(new Inference(
			new Predicate("free", new Term[] {
				new Variable(Type.STRING, "S",false)
			}),
			new OR(
				new ModuleFormula("ei",
					new Predicate("square", new Term[] {
						new Variable(Type.STRING, "S"),
						Primitive.newPrimitive("dust")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				),
				new ModuleFormula("ei",
					new Predicate("square", new Term[] {
						new Variable(Type.STRING, "S"),
						Primitive.newPrimitive("empty")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				)
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {13,5,13,30},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new ListTerm(new Term[] {
							new Variable(Type.STRING, "vacbot",false)
						})
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"VacBot", new int[] {13,29,17,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {14,1,14,14},
						new Predicate("join", new Term[] {
							Primitive.newPrimitive("hw")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).join(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("ei",
						"VacBot", new int[] {15,1,15,16},
						new Predicate("link", new Term[] {
							new Variable(Type.STRING, "vacbot")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).link(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("C",
						"VacBot", new int[] {16,1,16,30},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("VacBot activated")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("VacBot","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {19,5,19,43},
			new ModuleEvent("ei",
				"$eis",
				new Predicate("event", new Term[] {
					new Funct("location", new Term[] {
						new Variable(Type.LONG, "X",false),
						new Variable(Type.LONG, "y",false)
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.EIS) agent.getModule("VacBot","ei")).event(
							"+",
							predicate.getTerm(0)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"VacBot", new int[] {19,42,21,1},
				new Statement[] {
					new Subgoal(
						"VacBot", new int[] {20,5,21,1},
						new Goal(
							new Predicate("task", new Term[] {
								new Variable(Type.STRING, "action",false)
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {23,5,23,55},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					Primitive.newPrimitive("here"),
					Primitive.newPrimitive("dust")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"VacBot", new int[] {23,54,27,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {24,1,24,11},
						new Predicate("clean", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {25,1,27,1},
						Primitive.newPrimitive("clean")
					),
					new Subgoal(
						"VacBot", new int[] {26,1,27,1},
						new Goal(
							new Predicate("task", new Term[] {
								new Variable(Type.STRING, "action")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {29,5,29,58},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					Primitive.newPrimitive("forward"),
					Primitive.newPrimitive("dust")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"VacBot", new int[] {29,57,32,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {30,1,30,19},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("forward")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {31,1,32,1},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {34,5,34,55},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					Primitive.newPrimitive("left"),
					Primitive.newPrimitive("dust")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"VacBot", new int[] {34,54,37,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {35,1,35,16},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("left")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {36,1,37,1},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {39,5,39,56},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					Primitive.newPrimitive("right"),
					Primitive.newPrimitive("dust")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"VacBot", new int[] {39,55,42,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {40,1,40,17},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("right")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {41,1,42,1},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {44,5,44,45},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive("forward")
			}),
			new Block(
				"VacBot", new int[] {44,44,47,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {45,1,45,19},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("forward")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {46,1,47,1},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {49,5,49,42},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive("left")
			}),
			new Block(
				"VacBot", new int[] {49,41,52,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {50,1,50,16},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("left")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {51,1,52,1},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {54,5,54,43},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive("right")
			}),
			new Block(
				"VacBot", new int[] {54,42,57,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {55,1,55,17},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("right")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {56,1,57,1},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.addSensorAdaptor(new SensorAdaptor() {
			public void sense(astra.core.Agent agent) {
				((astra.lang.EIS) agent.getModule("VacBot","ei")).sense();
			}
		});

	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("ei",astra.lang.EIS.class,agent);
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
			astra.core.Agent agent = new VacBot().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: VacBot");
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
