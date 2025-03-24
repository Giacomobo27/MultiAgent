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


public class BetterR extends ASTRAClass {
	public BetterR() {
		setParents(new Class[] {Player.class});
		addInference(new Inference(
			new Predicate("winningLine", new Term[] {
				new Variable(Type.INTEGER, "L1",false),
				new Variable(Type.INTEGER, "L2",false),
				new Variable(Type.INTEGER, "L3",false)
			}),
			new AND(
				new Predicate("line", new Term[] {
					new Variable(Type.INTEGER, "L1"),
					new Variable(Type.INTEGER, "L2"),
					new Variable(Type.INTEGER, "L3")
				}),
				new AND(
					new Predicate("player", new Term[] {
						new Variable(Type.STRING, "T",false)
					}),
					new BracketFormula(
						new AND(
							new Predicate("played", new Term[] {
								new Variable(Type.STRING, "T"),
								new Variable(Type.INTEGER, "L1")
							}),
							new AND(
								new Predicate("played", new Term[] {
									new Variable(Type.STRING, "T"),
									new Variable(Type.INTEGER, "L2")
								}),
								new AND(
									new NOT(
										new Predicate("played", new Term[] {
											new Variable(Type.STRING, "T"),
											new Variable(Type.INTEGER, "L3")
										})
									),
									new Predicate("free", new Term[] {
										new Variable(Type.INTEGER, "L3")
									})
								)
							)
						)
					)
				)
			)
		));
		addRule(new Rule(
			"BetterR", new int[] {16,5,16,58},
			new GoalEvent('+',
				new Goal(
					new Predicate("move", new Term[] {
						new Variable(Type.INTEGER, "L",false)
					})
				)
			),
			new Predicate("winningLine", new Term[] {
				new Variable(Type.INTEGER, "L1",false),
				new Variable(Type.INTEGER, "L2",false),
				new Variable(Type.INTEGER, "L3",false)
			}),
			new Block(
				"BetterR", new int[] {16,57,19,1},
				new Statement[] {
					new ModuleCall("C",
						"BetterR", new int[] {17,4,17,32},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("moving to "),
								new Variable(Type.INTEGER, "L3")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("BetterR","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Assignment(
						new Variable(Type.INTEGER, "L"),
						"BetterR", new int[] {18,4,19,1},
						new Variable(Type.INTEGER, "L3")
					)
				}
			)
		));
		addRule(new Rule(
			"BetterR", new int[] {22,5,22,20},
			new GoalEvent('+',
				new Goal(
					new Predicate("move", new Term[] {
						new Variable(Type.INTEGER, "L",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"BetterR", new int[] {22,19,29,1},
				new Statement[] {
					new ModuleCall("C",
						"BetterR", new int[] {23,0,23,24},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Random move")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("BetterR","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Declaration(
						new Variable(Type.INTEGER, "L2"),
						"BetterR", new int[] {24,0,29,1},
						Operator.newOperator('+',
							new Brackets(
								Operator.newOperator('%',
									new ModuleTerm("math", Type.INTEGER,
										new Predicate("randomInt", new Term[] {}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((astra.lang.Math) intention.getModule("BetterR","math")).randomInt(
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.Math) visitor.agent().getModule("BetterR","math")).randomInt(
												);
											}
										}
									),
									Primitive.newPrimitive(9)
								)
							),
							Primitive.newPrimitive(1)
						)
					),
					new While(
						"BetterR", new int[] {25,0,29,1},
						new NOT(
							new Predicate("free", new Term[] {
								new Variable(Type.INTEGER, "L2")
							})
						),
						new Block(
							"BetterR", new int[] {25,18,27,1},
							new Statement[] {
								new Assignment(
									new Variable(Type.INTEGER, "L2"),
									"BetterR", new int[] {26,0,27,1},
									Operator.newOperator('+',
										new Brackets(
											Operator.newOperator('%',
												new ModuleTerm("math", Type.INTEGER,
													new Predicate("randomInt", new Term[] {}),
													new ModuleTermAdaptor() {
														public Object invoke(Intention intention, Predicate predicate) {
															return ((astra.lang.Math) intention.getModule("BetterR","math")).randomInt(
															);
														}
														public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((astra.lang.Math) visitor.agent().getModule("BetterR","math")).randomInt(
															);
														}
													}
												),
												Primitive.newPrimitive(9)
											)
										),
										Primitive.newPrimitive(1)
									)
								)
							}
						)
					),
					new Assignment(
						new Variable(Type.INTEGER, "L"),
						"BetterR", new int[] {28,0,29,1},
						new Variable(Type.INTEGER, "L2")
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
			astra.core.Agent agent = new BetterR().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: BetterR");
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
