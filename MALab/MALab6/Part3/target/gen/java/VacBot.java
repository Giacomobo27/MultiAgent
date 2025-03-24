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


public class VacBot extends ASTRAClass {
	public VacBot() {
		setParents(new Class[] {astra.lang.Agent.class});
		addInference(new Inference(
			new Predicate("free", new Term[] {
				new Variable(Type.STRING, "S",false)
			}),
			new OR(
				new ModuleFormula("ei",
					new Predicate("square", new Term[] {
						new Variable(Type.STRING, "S"),
						Primitive.newPrimitive("dust")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				),
				new ModuleFormula("ei",
					new Predicate("square", new Term[] {
						new Variable(Type.STRING, "S"),
						Primitive.newPrimitive("empty")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				)
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {18,5,18,30},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new ListTerm(new Term[] {
							new Variable(Type.STRING, "vacbot",false)
						})
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"VacBot", new int[] {18,29,22,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {19,1,19,14},
						new Predicate("join", new Term[] {
							Primitive.newPrimitive("hw")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).join(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("ei",
						"VacBot", new int[] {20,1,20,16},
						new Predicate("link", new Term[] {
							new Variable(Type.STRING, "vacbot")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).link(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("C",
						"VacBot", new int[] {21,1,21,30},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("VacBot activated")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("VacBot","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {25,5,25,71},
			new GoalEvent('+',
				new Goal(
					new Predicate("update", new Term[] {})
				)
			),
			new AND(
				new ModuleFormula("ei",
					new Predicate("location", new Term[] {
						new Variable(Type.LONG, "X",false),
						new Variable(Type.LONG, "Y",false)
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				),
				new ModuleFormula("ei",
					new Predicate("direction", new Term[] {
						new Variable(Type.STRING, "D",false)
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				)
			),
			new Block(
				"VacBot", new int[] {25,70,36,1},
				new Statement[] {
					new ModuleCall("C",
						"VacBot", new int[] {26,5,26,24},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("update")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("VacBot","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new If(
						"VacBot", new int[] {27,4,36,1},
						new Comparison(">=",
							new Variable(Type.LONG, "X"),
							new ModuleTerm("R", Type.LONG,
								new Predicate("maxX", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((Routing) intention.getModule("VacBot","R")).maxX(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((Routing) visitor.agent().getModule("VacBot","R")).maxX(
										);
									}
								}
							)
						),
						new Block(
							"VacBot", new int[] {27,19,29,5},
							new Statement[] {
								new ModuleCall("R",
									"VacBot", new int[] {28,8,28,38},
									new Predicate("updateBoundary", new Term[] {
										Operator.newOperator('+',
											new Variable(Type.LONG, "X"),
											Primitive.newPrimitive(4)
										),
										new ModuleTerm("R", Type.LONG,
											new Predicate("maxY", new Term[] {}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((Routing) intention.getModule("VacBot","R")).maxY(
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((Routing) visitor.agent().getModule("VacBot","R")).maxY(
													);
												}
											}
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((Routing) intention.getModule("VacBot","R")).updateBoundary(
												(java.lang.Long) intention.evaluate(predicate.getTerm(0)),
												(java.lang.Long) intention.evaluate(predicate.getTerm(1))
											);
										}
									}
								)
							}
						)
					),
					new If(
						"VacBot", new int[] {30,4,36,1},
						new Comparison(">=",
							new Variable(Type.LONG, "Y"),
							new ModuleTerm("R", Type.LONG,
								new Predicate("maxY", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((Routing) intention.getModule("VacBot","R")).maxY(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((Routing) visitor.agent().getModule("VacBot","R")).maxY(
										);
									}
								}
							)
						),
						new Block(
							"VacBot", new int[] {30,19,32,5},
							new Statement[] {
								new ModuleCall("R",
									"VacBot", new int[] {31,8,31,37},
									new Predicate("updateBoundary", new Term[] {
										new ModuleTerm("R", Type.LONG,
											new Predicate("maxX", new Term[] {}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((Routing) intention.getModule("VacBot","R")).maxX(
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((Routing) visitor.agent().getModule("VacBot","R")).maxX(
													);
												}
											}
										),
										Operator.newOperator('+',
											new Variable(Type.LONG, "Y"),
											Primitive.newPrimitive(4)
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((Routing) intention.getModule("VacBot","R")).updateBoundary(
												(java.lang.Long) intention.evaluate(predicate.getTerm(0)),
												(java.lang.Long) intention.evaluate(predicate.getTerm(1))
											);
										}
									}
								)
							}
						)
					),
					new ForEach(
						"VacBot", new int[] {33,4,36,1},
						new AND(
							new ModuleFormula("ei",
								new Predicate("square", new Term[] {
									new Variable(Type.STRING, "location",false),
									Primitive.newPrimitive("obstacle")
								}),
								new ModuleFormulaAdaptor() {
									public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
									}
								}
							),
							new NOT(
								new ModuleFormula("R",
									new Predicate("obstacle", new Term[] {
										new Variable(Type.LONG, "X"),
										new Variable(Type.LONG, "Y"),
										new Variable(Type.STRING, "D"),
										new Variable(Type.STRING, "location")
									}),
								new ModuleFormulaAdaptor() {
										public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
											return ((Routing) visitor.agent().getModule("VacBot","R")).obstacle(
												(long) visitor.evaluate(predicate.getTerm(0)),
												(long) visitor.evaluate(predicate.getTerm(1)),
												(java.lang.String) visitor.evaluate(predicate.getTerm(2)),
												(java.lang.String) visitor.evaluate(predicate.getTerm(3))
											);
									}
								}
									)
							)
						),
						new Block(
							"VacBot", new int[] {33,85,35,1},
							new Statement[] {
								new ModuleCall("R",
									"VacBot", new int[] {34,6,34,41},
									new Predicate("recordObstacle", new Term[] {
										new Variable(Type.LONG, "X"),
										new Variable(Type.LONG, "Y"),
										new Variable(Type.STRING, "D"),
										new Variable(Type.STRING, "location")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((Routing) intention.getModule("VacBot","R")).recordObstacle(
												(java.lang.Long) intention.evaluate(predicate.getTerm(0)),
												(java.lang.Long) intention.evaluate(predicate.getTerm(1)),
												(java.lang.String) intention.evaluate(predicate.getTerm(2)),
												(java.lang.String) intention.evaluate(predicate.getTerm(3))
											);
										}
									}
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {38,5,38,46},
			new GoalEvent('+',
				new Goal(
					new Predicate("route", new Term[] {})
				)
			),
			new ModuleFormula("ei",
				new Predicate("location", new Term[] {
					new Variable(Type.LONG, "x",false),
					new Variable(Type.LONG, "y",false)
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"VacBot", new int[] {38,45,43,1},
				new Statement[] {
					new Declaration(
						new Variable(Type.LIST, "L"),
						"VacBot", new int[] {39,4,43,1},
						new ModuleTerm("R", Type.LIST,
							new Predicate("routeTo", new Term[] {
								new Variable(Type.LONG, "x"),
								new Variable(Type.LONG, "y"),
								Primitive.newPrimitive(4l),
								Primitive.newPrimitive(4l)
							}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((Routing) intention.getModule("VacBot","R")).routeTo(
										(long) intention.evaluate(predicate.getTerm(0)),
										(long) intention.evaluate(predicate.getTerm(1)),
										(long) intention.evaluate(predicate.getTerm(2)),
										(long) intention.evaluate(predicate.getTerm(3))
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((Routing) visitor.agent().getModule("VacBot","R")).routeTo(
										(long) visitor.evaluate(predicate.getTerm(0)),
										(long) visitor.evaluate(predicate.getTerm(1)),
										(long) visitor.evaluate(predicate.getTerm(2)),
										(long) visitor.evaluate(predicate.getTerm(3))
									);
								}
							}
						)
					),
					new ModuleCall("C",
						"VacBot", new int[] {42,4,42,31},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("ROUTING:::::::")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("VacBot","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {46,5,46,55},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					Primitive.newPrimitive("here"),
					Primitive.newPrimitive("dust")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"VacBot", new int[] {46,54,52,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {48,1,48,11},
						new Predicate("clean", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {49,1,52,1},
						Primitive.newPrimitive("clean")
					),
					new Wait(
						"VacBot", new int[] {50,1,52,1},
						new ModuleFormula("ei",
							new Predicate("task", new Term[] {
								Primitive.newPrimitive("none")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new Subgoal(
						"VacBot", new int[] {51,1,52,1},
						new Goal(
							new Predicate("task", new Term[] {
								new Variable(Type.STRING, "action")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {54,5,54,58},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					Primitive.newPrimitive("forward"),
					Primitive.newPrimitive("dust")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"VacBot", new int[] {54,57,57,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {55,1,55,19},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("forward")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {56,1,57,1},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {59,5,59,55},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					Primitive.newPrimitive("left"),
					Primitive.newPrimitive("dust")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"VacBot", new int[] {59,54,62,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {60,1,60,16},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("left")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {61,1,62,1},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {64,5,64,56},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					Primitive.newPrimitive("right"),
					Primitive.newPrimitive("dust")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"VacBot", new int[] {64,55,67,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {65,1,65,17},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("right")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {66,1,67,1},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {69,5,69,45},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive("forward")
			}),
			new Block(
				"VacBot", new int[] {69,44,72,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {70,1,70,19},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("forward")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {71,1,72,1},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {74,5,74,42},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive("left")
			}),
			new Block(
				"VacBot", new int[] {74,41,77,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {75,1,75,16},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("left")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {76,1,77,1},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {79,5,79,43},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive("right")
			}),
			new Block(
				"VacBot", new int[] {79,42,82,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {80,1,80,17},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("right")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {81,1,82,1},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {84,5,84,50},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new Predicate("route", new Term[] {
				new ListTerm(new Term[] {
					new Variable(Type.FUNCTION, "move",false)
				})
			}),
			new Block(
				"VacBot", new int[] {84,49,87,1},
				new Statement[] {
					new BeliefUpdate('-',
						"VacBot", new int[] {85,0,87,1},
						new Predicate("route", new Term[] {
							new ListTerm(new Term[] {
								new Variable(Type.FUNCTION, "move")
							})
						})
					),
					new Subgoal(
						"VacBot", new int[] {86,1,87,1},
						new Goal(
							new Predicate("go", new Term[] {
								new Variable(Type.FUNCTION, "move"),
								new Variable(Type.STRING, "action")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {88,5,88,58},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new Predicate("route", new Term[] {
				new ListSplitter(
					new Variable(Type.FUNCTION, "move",false),
					new Variable(Type.LIST, "L",false)
				)
			}),
			new Block(
				"VacBot", new int[] {88,57,91,1},
				new Statement[] {
					new SpecialBeliefUpdate(
						"VacBot", new int[] {89,1,91,1},
						new Predicate("route", new Term[] {
							new Variable(Type.LIST, "L")
						})
					),
					new Subgoal(
						"VacBot", new int[] {90,1,91,1},
						new Goal(
							new Predicate("go", new Term[] {
								new Variable(Type.FUNCTION, "move"),
								new Variable(Type.STRING, "action")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {93,5,93,50},
			new GoalEvent('+',
				new Goal(
					new Predicate("go", new Term[] {
						new Funct("move", new Term[] {
							new Variable(Type.STRING, "direction",false)
						}),
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"VacBot", new int[] {93,49,97,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {94,1,94,19},
						new Predicate("move", new Term[] {
							new Variable(Type.STRING, "direction")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {95,0,97,1},
						Primitive.newPrimitive("direction")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {99,5,99,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"VacBot", new int[] {99,27,111,1},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {100,4,100,18},
						new Predicate("dumpState", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).dumpState(
								);
							}
						}
					),
					new ModuleCall("C",
						"VacBot", new int[] {101,5,101,87},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("VacBot","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("C",
						"VacBot", new int[] {102,4,102,26},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("no action")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("VacBot","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("ei",
						"VacBot", new int[] {103,4,103,20},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("right")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new ModuleCall("C",
						"VacBot", new int[] {105,4,105,28},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("turn around")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("VacBot","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("ei",
						"VacBot", new int[] {106,5,106,21},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("right")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Wait(
						"VacBot", new int[] {107,5,111,1},
						new ModuleFormula("ei",
							new Predicate("move", new Term[] {
								Primitive.newPrimitive("right")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new ModuleCall("ei",
						"VacBot", new int[] {108,5,108,23},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("forward")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Wait(
						"VacBot", new int[] {109,4,111,1},
						new ModuleFormula("ei",
							new Predicate("move", new Term[] {
								Primitive.newPrimitive("forward")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new Subgoal(
						"VacBot", new int[] {110,4,111,1},
						new Goal(
							new Predicate("update", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {119,5,119,43},
			new ModuleEvent("ei",
				"$eis",
				new Predicate("event", new Term[] {
					new Funct("location", new Term[] {
						new Variable(Type.LONG, "X",false),
						new Variable(Type.LONG, "y",false)
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.EIS) agent.getModule("VacBot","ei")).event(
							"+",
							predicate.getTerm(0)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"VacBot", new int[] {119,42,124,1},
				new Statement[] {
					new Subgoal(
						"VacBot", new int[] {120,5,124,1},
						new Goal(
							new Predicate("update", new Term[] {})
						)
					),
					new Subgoal(
						"VacBot", new int[] {121,5,124,1},
						new Goal(
							new Predicate("route", new Term[] {})
						)
					),
					new Subgoal(
						"VacBot", new int[] {122,5,124,1},
						new Goal(
							new Predicate("task", new Term[] {
								new Variable(Type.STRING, "action",false)
							})
						)
					),
					new ModuleCall("ei",
						"VacBot", new int[] {123,5,123,19},
						new Predicate("dumpState", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).dumpState(
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
				((astra.lang.EIS) agent.getModule("VacBot","ei")).sense();
			}
		});

	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("ei",astra.lang.EIS.class,agent);
		fragment.addModule("C",astra.lang.Console.class,agent);
		fragment.addModule("R",Routing.class,agent);
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
			astra.core.Agent agent = new VacBot().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: VacBot");
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
