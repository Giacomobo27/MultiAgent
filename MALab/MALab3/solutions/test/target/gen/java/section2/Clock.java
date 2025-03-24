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


public class Clock extends ASTRAClass {
	public Clock() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"section2.Clock", new int[] {20,9,20,31},
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
				"section2.Clock", new int[] {20,30,23,5},
				new Statement[] {
					new ModuleCall("C",
						"section2.Clock", new int[] {21,8,21,41},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("SIMULATION FINISHED!")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("section2.Clock","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("S",
						"section2.Clock", new int[] {22,8,22,16},
						new Predicate("exit", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("section2.Clock","S")).exit(
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"section2.Clock", new int[] {25,9,25,28},
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
				"section2.Clock", new int[] {25,27,27,5},
				new Statement[] {
					new Subgoal(
						"section2.Clock", new int[] {26,8,27,5},
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
			"section2.Clock", new int[] {29,9,29,32},
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
				"section2.Clock", new int[] {29,31,34,5},
				new Statement[] {
					new SpecialBeliefUpdate(
						"section2.Clock", new int[] {30,8,34,5},
						new Predicate("clock", new Term[] {
							new Variable(Type.INTEGER, "D"),
							new Variable(Type.INTEGER, "H")
						})
					),
					new ModuleCall("C",
						"section2.Clock", new int[] {31,8,31,48},
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
								return ((astra.lang.Console) intention.getModule("section2.Clock","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("S",
						"section2.Clock", new int[] {32,8,32,22},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(1000)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("section2.Clock","S")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new SpawnGoal(
						"section2.Clock", new int[] {33,8,34,5},
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
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Goal(
				new Predicate("clock", new Term[] {
					Primitive.newPrimitive(0),
					Primitive.newPrimitive(0)
				})
			)
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
			astra.core.Agent agent = new Clock().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: Clock");
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
