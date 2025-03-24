package example;
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


public class LightSwitch extends ASTRAClass {
	public LightSwitch() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"example.LightSwitch", new int[] {16,9,16,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"example.LightSwitch", new int[] {16,27,16,45},
				new Statement[] {
					new Subgoal(
						"example.LightSwitch", new int[] {16,29,16,45},
						new Goal(
							new Predicate("switch", new Term[] {
								Primitive.newPrimitive("on")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"example.LightSwitch", new int[] {17,9,17,67},
			new GoalEvent('+',
				new Goal(
					new Predicate("switch", new Term[] {
						new Variable(Type.STRING, "S",false)
					})
				)
			),
			new AND(
				new Predicate("transition", new Term[] {
					new Variable(Type.STRING, "R",false),
					new Variable(Type.STRING, "S")
				}),
				new Predicate("switch", new Term[] {
					new Variable(Type.STRING, "R")
				})
			),
			new Block(
				"example.LightSwitch", new int[] {17,66,17,84},
				new Statement[] {
					new ModuleCall("switch",
						"example.LightSwitch", new int[] {17,68,17,81},
						new Predicate("set", new Term[] {
							new Variable(Type.STRING, "S")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((example.Switch) intention.getModule("example.LightSwitch","switch")).set(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"example.LightSwitch", new int[] {18,9,18,28},
			new BeliefEvent('+',
				new Predicate("switch", new Term[] {
					new Variable(Type.STRING, "S",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"example.LightSwitch", new int[] {18,27,18,41},
				new Statement[] {
					new Subgoal(
						"example.LightSwitch", new int[] {18,29,18,41},
						new Goal(
							new Predicate("light", new Term[] {
								new Variable(Type.STRING, "S")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"example.LightSwitch", new int[] {19,9,19,65},
			new GoalEvent('+',
				new Goal(
					new Predicate("light", new Term[] {
						new Variable(Type.STRING, "S",false)
					})
				)
			),
			new AND(
				new Predicate("transition", new Term[] {
					new Variable(Type.STRING, "R",false),
					new Variable(Type.STRING, "S")
				}),
				new Predicate("light", new Term[] {
					new Variable(Type.STRING, "R")
				})
			),
			new Block(
				"example.LightSwitch", new int[] {19,64,19,81},
				new Statement[] {
					new ModuleCall("light",
						"example.LightSwitch", new int[] {19,66,19,78},
						new Predicate("set", new Term[] {
							new Variable(Type.STRING, "S")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((example.Light) intention.getModule("example.LightSwitch","light")).set(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"example.LightSwitch", new int[] {20,9,20,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("light", new Term[] {
						new Variable(Type.STRING, "S",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"example.LightSwitch", new int[] {20,27,20,30},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"example.LightSwitch", new int[] {21,9,21,27},
			new BeliefEvent('+',
				new Predicate("light", new Term[] {
					new Variable(Type.STRING, "S",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"example.LightSwitch", new int[] {21,26,21,66},
				new Statement[] {
					new ModuleCall("C",
						"example.LightSwitch", new int[] {21,28,21,63},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Light is in state "),
								new Variable(Type.STRING, "S")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("example.LightSwitch","C")).println(
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
				((example.Switch) agent.getModule("example.LightSwitch","switch")).sense();
			}
		});

		agent.addSensorAdaptor(new SensorAdaptor() {
			public void sense(astra.core.Agent agent) {
				((example.Light) agent.getModule("example.LightSwitch","light")).sense();
			}
		});

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
		fragment.addModule("switch",example.Switch.class,agent);
		fragment.addModule("light",example.Light.class,agent);
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
			astra.core.Agent agent = new LightSwitch().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: LightSwitch");
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
