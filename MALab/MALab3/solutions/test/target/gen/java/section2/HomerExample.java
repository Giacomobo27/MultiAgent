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


public class HomerExample extends ASTRAClass {
	public HomerExample() {
		setParents(new Class[] {section2.Homer.class});
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("in", new Term[] {
				Primitive.newPrimitive("office"),
				Primitive.newPrimitive("desk")
			})
		);
		agent.initialize(
			new Predicate("in", new Term[] {
				Primitive.newPrimitive("bedroom"),
				Primitive.newPrimitive("bed")
			})
		);
		agent.initialize(
			new Predicate("in", new Term[] {
				Primitive.newPrimitive("kitchen"),
				Primitive.newPrimitive("fridge")
			})
		);
		agent.initialize(
			new Predicate("in", new Term[] {
				Primitive.newPrimitive("bathroom"),
				Primitive.newPrimitive("shower")
			})
		);
		agent.initialize(
			new Predicate("in", new Term[] {
				Primitive.newPrimitive("lounge"),
				Primitive.newPrimitive("couch")
			})
		);
		agent.initialize(
			new Predicate("in", new Term[] {
				Primitive.newPrimitive("kitchen"),
				Primitive.newPrimitive("cooker")
			})
		);
		agent.initialize(
			new Predicate("in", new Term[] {
				Primitive.newPrimitive("dining_room"),
				Primitive.newPrimitive("table")
			})
		);
		agent.initialize(
			new Predicate("in", new Term[] {
				Primitive.newPrimitive("lounge"),
				Primitive.newPrimitive("tv")
			})
		);
		agent.initialize(
			new Predicate("needs", new Term[] {
				Primitive.newPrimitive("breakfast"),
				Primitive.newPrimitive("fridge")
			})
		);
		agent.initialize(
			new Predicate("needs", new Term[] {
				Primitive.newPrimitive("lunch"),
				Primitive.newPrimitive("fridge")
			})
		);
		agent.initialize(
			new Predicate("needs", new Term[] {
				Primitive.newPrimitive("make_dinner"),
				Primitive.newPrimitive("cooker")
			})
		);
		agent.initialize(
			new Predicate("needs", new Term[] {
				Primitive.newPrimitive("eat_dinner"),
				Primitive.newPrimitive("table")
			})
		);
		agent.initialize(
			new Predicate("needs", new Term[] {
				Primitive.newPrimitive("wash"),
				Primitive.newPrimitive("shower")
			})
		);
		agent.initialize(
			new Predicate("needs", new Term[] {
				Primitive.newPrimitive("work"),
				Primitive.newPrimitive("desk")
			})
		);
		agent.initialize(
			new Predicate("needs", new Term[] {
				Primitive.newPrimitive("watch_tv"),
				Primitive.newPrimitive("tv")
			})
		);
		agent.initialize(
			new Predicate("needs", new Term[] {
				Primitive.newPrimitive("sleep"),
				Primitive.newPrimitive("bed")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(7),
				Primitive.newPrimitive("breakfast")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(8),
				Primitive.newPrimitive("wash")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(9),
				Primitive.newPrimitive("work")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(13),
				Primitive.newPrimitive("lunch")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(14),
				Primitive.newPrimitive("work")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(17),
				Primitive.newPrimitive("make_dinner")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(18),
				Primitive.newPrimitive("eat_dinner")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(19),
				Primitive.newPrimitive("watch_tv")
			})
		);
		agent.initialize(
			new Predicate("daily_schedule", new Term[] {
				Primitive.newPrimitive(22),
				Primitive.newPrimitive("sleep")
			})
		);
		agent.initialize(
			new Predicate("activity", new Term[] {
				Primitive.newPrimitive("sleep")
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
			astra.core.Agent agent = new HomerExample().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: HomerExample");
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
