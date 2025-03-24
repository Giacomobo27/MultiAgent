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


public class Opponent extends ASTRAClass {
	public Opponent() {
		setParents(new Class[] {Player.class});
		addRule(new Rule(
			"Opponent", new int[] {4,5,4,29},
			new GoalEvent('+',
				new Goal(
					new Predicate("move", new Term[] {
						new Variable(Type.INTEGER, "L",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive(2)
			}),
			new Block(
				"Opponent", new int[] {4,28,4,35},
				new Statement[] {
					new Assignment(
						new Variable(Type.INTEGER, "L"),
						"Opponent", new int[] {4,30,4,35},
						Primitive.newPrimitive(2)
					)
				}
			)
		));
		addRule(new Rule(
			"Opponent", new int[] {5,5,5,29},
			new GoalEvent('+',
				new Goal(
					new Predicate("move", new Term[] {
						new Variable(Type.INTEGER, "L",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive(8)
			}),
			new Block(
				"Opponent", new int[] {5,28,5,35},
				new Statement[] {
					new Assignment(
						new Variable(Type.INTEGER, "L"),
						"Opponent", new int[] {5,30,5,35},
						Primitive.newPrimitive(8)
					)
				}
			)
		));
		addRule(new Rule(
			"Opponent", new int[] {6,5,6,29},
			new GoalEvent('+',
				new Goal(
					new Predicate("move", new Term[] {
						new Variable(Type.INTEGER, "L",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive(5)
			}),
			new Block(
				"Opponent", new int[] {6,28,6,35},
				new Statement[] {
					new Assignment(
						new Variable(Type.INTEGER, "L"),
						"Opponent", new int[] {6,30,6,35},
						Primitive.newPrimitive(5)
					)
				}
			)
		));
		addRule(new Rule(
			"Opponent", new int[] {7,5,7,29},
			new GoalEvent('+',
				new Goal(
					new Predicate("move", new Term[] {
						new Variable(Type.INTEGER, "L",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive(9)
			}),
			new Block(
				"Opponent", new int[] {7,28,7,35},
				new Statement[] {
					new Assignment(
						new Variable(Type.INTEGER, "L"),
						"Opponent", new int[] {7,30,7,35},
						Primitive.newPrimitive(9)
					)
				}
			)
		));
		addRule(new Rule(
			"Opponent", new int[] {8,5,8,29},
			new GoalEvent('+',
				new Goal(
					new Predicate("move", new Term[] {
						new Variable(Type.INTEGER, "L",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive(6)
			}),
			new Block(
				"Opponent", new int[] {8,28,8,35},
				new Statement[] {
					new Assignment(
						new Variable(Type.INTEGER, "L"),
						"Opponent", new int[] {8,30,8,35},
						Primitive.newPrimitive(6)
					)
				}
			)
		));
		addRule(new Rule(
			"Opponent", new int[] {9,5,9,29},
			new GoalEvent('+',
				new Goal(
					new Predicate("move", new Term[] {
						new Variable(Type.INTEGER, "L",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive(1)
			}),
			new Block(
				"Opponent", new int[] {9,28,9,35},
				new Statement[] {
					new Assignment(
						new Variable(Type.INTEGER, "L"),
						"Opponent", new int[] {9,30,9,35},
						Primitive.newPrimitive(1)
					)
				}
			)
		));
		addRule(new Rule(
			"Opponent", new int[] {10,5,10,29},
			new GoalEvent('+',
				new Goal(
					new Predicate("move", new Term[] {
						new Variable(Type.INTEGER, "L",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive(7)
			}),
			new Block(
				"Opponent", new int[] {10,28,10,35},
				new Statement[] {
					new Assignment(
						new Variable(Type.INTEGER, "L"),
						"Opponent", new int[] {10,30,10,35},
						Primitive.newPrimitive(7)
					)
				}
			)
		));
		addRule(new Rule(
			"Opponent", new int[] {11,5,11,29},
			new GoalEvent('+',
				new Goal(
					new Predicate("move", new Term[] {
						new Variable(Type.INTEGER, "L",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive(3)
			}),
			new Block(
				"Opponent", new int[] {11,28,11,35},
				new Statement[] {
					new Assignment(
						new Variable(Type.INTEGER, "L"),
						"Opponent", new int[] {11,30,11,35},
						Primitive.newPrimitive(3)
					)
				}
			)
		));
		addRule(new Rule(
			"Opponent", new int[] {12,5,12,29},
			new GoalEvent('+',
				new Goal(
					new Predicate("move", new Term[] {
						new Variable(Type.INTEGER, "L",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive(4)
			}),
			new Block(
				"Opponent", new int[] {12,28,12,35},
				new Statement[] {
					new Assignment(
						new Variable(Type.INTEGER, "L"),
						"Opponent", new int[] {12,30,12,35},
						Primitive.newPrimitive(4)
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
			astra.core.Agent agent = new Opponent().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: Opponent");
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
