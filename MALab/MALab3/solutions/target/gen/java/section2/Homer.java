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


public class Homer extends ASTRAClass {
	public Homer() {
		setParents(new Class[] {Daily.class});
		addRule(new Rule(
			"section2.Homer", new int[] {13,9,13,68},
			new BeliefEvent('+',
				new Predicate("clock", new Term[] {
					new Variable(Type.INTEGER, "D",false),
					new Variable(Type.INTEGER, "H",false)
				})
			),
			new Predicate("daily_schedule", new Term[] {
				new Variable(Type.INTEGER, "H"),
				new Variable(Type.STRING, "activity",false)
			}),
			new Block(
				"section2.Homer", new int[] {13,67,15,5},
				new Statement[] {
					new Subgoal(
						"section2.Homer", new int[] {14,8,15,5},
						new Goal(
							new Predicate("activity", new Term[] {
								new Variable(Type.STRING, "activity")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"section2.Homer", new int[] {20,9,20,59},
			new GoalEvent('+',
				new Goal(
					new Predicate("activity", new Term[] {
						new Variable(Type.STRING, "activity",false)
					})
				)
			),
			new Predicate("activity", new Term[] {
				new Variable(Type.STRING, "activity")
			}),
			new Block(
				"section2.Homer", new int[] {20,58,20,61},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"section2.Homer", new int[] {22,9,24,31},
			new GoalEvent('+',
				new Goal(
					new Predicate("activity", new Term[] {
						new Variable(Type.STRING, "activity",false)
					})
				)
			),
			new AND(
				new Predicate("needs", new Term[] {
					new Variable(Type.STRING, "activity"),
					new Variable(Type.STRING, "item",false)
				}),
				new AND(
					new Predicate("in", new Term[] {
						new Variable(Type.STRING, "target",false),
						new Variable(Type.STRING, "item")
					}),
					new Predicate("current", new Term[] {
						new Variable(Type.STRING, "target")
					})
				)
			),
			new Block(
				"section2.Homer", new int[] {24,30,27,5},
				new Statement[] {
					new SpecialBeliefUpdate(
						"section2.Homer", new int[] {25,8,27,5},
						new Predicate("activity", new Term[] {
							new Variable(Type.STRING, "activity")
						})
					),
					new ModuleCall("C",
						"section2.Homer", new int[] {26,8,26,39},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Doing: "),
								new Variable(Type.STRING, "activity")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("section2.Homer","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"section2.Homer", new int[] {29,9,30,70},
			new GoalEvent('+',
				new Goal(
					new Predicate("activity", new Term[] {
						new Variable(Type.STRING, "activity",false)
					})
				)
			),
			new AND(
				new Predicate("needs", new Term[] {
					new Variable(Type.STRING, "activity"),
					new Variable(Type.STRING, "item",false)
				}),
				new Predicate("in", new Term[] {
					new Variable(Type.STRING, "target",false),
					new Variable(Type.STRING, "item")
				})
			),
			new Block(
				"section2.Homer", new int[] {30,69,33,5},
				new Statement[] {
					new Subgoal(
						"section2.Homer", new int[] {31,8,33,5},
						new Goal(
							new Predicate("current", new Term[] {
								new Variable(Type.STRING, "target")
							})
						)
					),
					new Subgoal(
						"section2.Homer", new int[] {32,8,33,5},
						new Goal(
							new Predicate("activity", new Term[] {
								new Variable(Type.STRING, "activity")
							})
						)
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
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
			astra.core.Agent agent = new Homer().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: Homer");
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
