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


public class Part1 extends ASTRAClass {
	public Part1() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"section1.Part1", new int[] {17,9,17,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"section1.Part1", new int[] {17,27,19,5},
				new Statement[] {
					new BeliefUpdate('+',
						"section1.Part1", new int[] {18,8,19,5},
						new Predicate("switch", new Term[] {
							Primitive.newPrimitive("s1"),
							Primitive.newPrimitive("on")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"section1.Part1", new int[] {21,9,22,38},
			new BeliefEvent('+',
				new Predicate("switch", new Term[] {
					new Variable(Type.STRING, "S",false),
					new Variable(Type.STRING, "state",false)
				})
			),
			new Predicate("connected", new Term[] {
				new Variable(Type.STRING, "S"),
				new Variable(Type.STRING, "L",false)
			}),
			new Block(
				"section1.Part1", new int[] {22,37,24,5},
				new Statement[] {
					new Subgoal(
						"section1.Part1", new int[] {23,8,24,5},
						new Goal(
							new Predicate("light", new Term[] {
								new Variable(Type.STRING, "L"),
								new Variable(Type.STRING, "state")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"section1.Part1", new int[] {26,9,26,60},
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
				"section1.Part1", new int[] {26,59,26,62},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"section1.Part1", new int[] {28,9,29,63},
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
				"section1.Part1", new int[] {29,62,32,5},
				new Statement[] {
					new BeliefUpdate('-',
						"section1.Part1", new int[] {30,8,32,5},
						new Predicate("light", new Term[] {
							new Variable(Type.STRING, "L"),
							new Variable(Type.STRING, "from")
						})
					),
					new BeliefUpdate('+',
						"section1.Part1", new int[] {31,8,32,5},
						new Predicate("light", new Term[] {
							new Variable(Type.STRING, "L"),
							new Variable(Type.STRING, "state")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"section1.Part1", new int[] {34,9,34,41},
			new BeliefEvent('+',
				new Predicate("light", new Term[] {
					new Variable(Type.STRING, "L",false),
					new Variable(Type.STRING, "state",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"section1.Part1", new int[] {34,40,36,5},
				new Statement[] {
					new ModuleCall("C",
						"section1.Part1", new int[] {35,8,35,58},
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
								return ((astra.lang.Console) intention.getModule("section1.Part1","C")).println(
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
			astra.core.Agent agent = new Part1().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: Part1");
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
