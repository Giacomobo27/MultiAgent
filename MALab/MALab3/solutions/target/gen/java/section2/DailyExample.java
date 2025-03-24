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


public class DailyExample extends ASTRAClass {
	public DailyExample() {
		setParents(new Class[] {section2.Daily.class});
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(6),
				Primitive.newPrimitive("kitchen")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(7),
				Primitive.newPrimitive("bathroom")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(8),
				Primitive.newPrimitive("lounge")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(12),
				Primitive.newPrimitive("kitchen")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(13),
				Primitive.newPrimitive("lounge")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(17),
				Primitive.newPrimitive("kitchen")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(18),
				Primitive.newPrimitive("dining_room")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(19),
				Primitive.newPrimitive("lounge")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(22),
				Primitive.newPrimitive("bedroom")
			})
		);
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
			astra.core.Agent agent = new DailyExample().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: DailyExample");
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
