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


public class Daily extends ASTRAClass {
	public Daily() {
		setParents(new Class[] {Mover.class,Clock.class});
		addRule(new Rule(
			"section2.Daily", new int[] {7,9,7,68},
			new BeliefEvent('+',
				new Predicate("clock", new Term[] {
					new Variable(Type.INTEGER, "D",false),
					new Variable(Type.INTEGER, "H",false)
				})
			),
			new Predicate("daily_schedule", new Term[] {
				new Variable(Type.INTEGER, "H"),
				new Variable(Type.STRING, "location",false)
			}),
			new Block(
				"section2.Daily", new int[] {7,67,9,5},
				new Statement[] {
					new Subgoal(
						"section2.Daily", new int[] {8,8,9,5},
						new Goal(
							new Predicate("current", new Term[] {
								new Variable(Type.STRING, "location")
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
			astra.core.Agent agent = new Daily().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: Daily");
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
