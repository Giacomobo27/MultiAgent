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


public class light extends ASTRAClass {
	public light() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"light", new int[] {25,9,25,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"light", new int[] {25,27,27,5},
				new Statement[] {
					new BeliefUpdate('+',
						"light", new int[] {26,8,27,5},
						new Predicate("switch", new Term[] {
							Primitive.newPrimitive("s1"),
							Primitive.newPrimitive("on")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"light", new int[] {29,9,29,39},
			new BeliefEvent('+',
				new Predicate("light", new Term[] {
					new Variable(Type.STRING, "Lt",false),
					new Variable(Type.STRING, "St",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"light", new int[] {29,38,31,5},
				new Statement[] {
					new ModuleCall("c",
						"light", new int[] {30,8,30,53},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Light:"),
								Operator.newOperator('+',
									new Variable(Type.STRING, "Lt"),
									Operator.newOperator('+',
										Primitive.newPrimitive(" is in state:"),
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
								return ((astra.lang.Console) intention.getModule("light","c")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"light", new int[] {33,9,33,71},
			new BeliefEvent('+',
				new Predicate("switch", new Term[] {
					new Variable(Type.STRING, "Sw",false),
					new Variable(Type.STRING, "St",false)
				})
			),
			new Predicate("connected", new Term[] {
				new Variable(Type.STRING, "Sw"),
				new Variable(Type.STRING, "Lt",false)
			}),
			new Block(
				"light", new int[] {33,70,35,24},
				new Statement[] {
					new Subgoal(
						"light", new int[] {35,8,35,24},
						new Goal(
							new Predicate("light", new Term[] {
								new Variable(Type.STRING, "Lt"),
								new Variable(Type.STRING, "St")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"light", new int[] {37,9,37,91},
			new GoalEvent('+',
				new Goal(
					new Predicate("light", new Term[] {
						new Variable(Type.STRING, "Lt",false),
						new Variable(Type.STRING, "St",false)
					})
				)
			),
			new AND(
				new Predicate("transition", new Term[] {
					new Variable(Type.STRING, "OldSt",false),
					new Variable(Type.STRING, "St")
				}),
				new Predicate("light", new Term[] {
					new Variable(Type.STRING, "Lt"),
					new Variable(Type.STRING, "OldSt")
				})
			),
			new Block(
				"light", new int[] {37,90,39,5},
				new Statement[] {
					new BeliefUpdate('-',
						"light", new int[] {38,8,39,5},
						new Predicate("light", new Term[] {
							new Variable(Type.STRING, "Lt"),
							new Variable(Type.STRING, "OldSt")
						})
					),
					new BeliefUpdate('+',
						"light", new int[] {38,27,39,5},
						new Predicate("light", new Term[] {
							new Variable(Type.STRING, "Lt"),
							new Variable(Type.STRING, "St")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"light", new int[] {40,9,40,40},
			new GoalEvent('+',
				new Goal(
					new Predicate("light", new Term[] {
						new Variable(Type.STRING, "Lt",false),
						new Variable(Type.STRING, "St",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"light", new int[] {40,39,40,42},
				new Statement[] {
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
		fragment.addModule("c",astra.lang.Console.class,agent);
		fragment.addModule("d",astra.lang.Debug.class,agent);
		fragment.addModule("s",astra.lang.System.class,agent);
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
			astra.core.Agent agent = new light().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: light");
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
