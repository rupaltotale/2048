import java.util.ArrayList;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class GridBasedGameDriver {

	private static final int NUM_COLS = 4;
	private static final int NUM_ROWS = 4;
	private int[][] grid = new int[4][4];
	private static boolean change = false;

	World<Object> world = new World<Object>() {

		@Override
		public boolean locationClicked(Location loc) {
			System.out.println("You just clicked " + loc);

			return false;
		}

		@Override
		public boolean keyPressed(String key, Location loc) {
			// System.out.println("You just pressed the " + key + " key.");
			if (key.equals("LEFT")) {
				slide(3);
			} else if (key.equals("RIGHT")) {
				slideRight(2);
			} else if (key.equals("DOWN")) {
				slideDown(1);
			} else if (key.equals("UP")) {
				slide(0);
			}
			else if(key.equals("Z")) {
				System.out.println("z");
				undo();
			}
			if (change) {
				random();
				change = false;
			}
			showGrid();

			return false;
		}

		private void undo() {
			
			
		}

		ArrayList<ArrayList<Integer>> neighbors(int r, int c) {
			ArrayList<ArrayList<Integer>> n = new ArrayList<ArrayList<Integer>>();
			// up:0
			ArrayList<Integer> up = new ArrayList<Integer>();
			up.add(r - 1);
			up.add(c);
			n.add(up);
			// down:1
			ArrayList<Integer> down = new ArrayList<Integer>();
			down.add(r + 1);
			down.add(c);
			n.add(down);
			// right:2
			ArrayList<Integer> right = new ArrayList<Integer>();
			right.add(r);
			right.add(c + 1);
			n.add(right);
			// left:3
			ArrayList<Integer> left = new ArrayList<Integer>();
			left.add(r);
			left.add(c - 1);
			n.add(left);
			return n;
		}

		void slide(int n) {
			ArrayList<ArrayList<Integer>> neighbors;
			int slide = 0;
			while (slide < grid.length) {
				for (int r = 0; r < grid.length; r++) {
					for (int c = 0; c < grid.length; c++) {
						if (grid[r][c] != 0) {
							neighbors = neighbors(r, c);

							if (inBounds(neighbors.get(n).get(0), neighbors.get(n).get(1))) {

								if (grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] == 0) {
									grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] = grid[r][c];
									grid[r][c] = 0;
									change = true;

								}
							}

						}

					}
				}

				slide++;

			}

			// merge

			for (int r = 0; r < grid.length; r++) {
				for (int c = 0; c < grid.length; c++) {
					if (grid[r][c] != 0) {
						neighbors = neighbors(r, c);
						if (inBounds(neighbors.get(n).get(0), neighbors.get(n).get(1))) {
							if (grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] == grid[r][c]) {
								// if (merge.indexOf(new Location(r, c)) == -1) {
								grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] *= 2;
								grid[r][c] = 0;
								// merge.add(new Location(r, c - 1));
								change = true;

								// }

							}

						}
					}
				}
			}

			slide = 0;

			while (slide < grid.length) {
				for (int r = 0; r < grid.length; r++) {
					for (int c = 0; c < grid.length; c++) {
						if (grid[r][c] != 0) {
							neighbors = neighbors(r, c);
							if (inBounds(neighbors.get(n).get(0), neighbors.get(n).get(1))) {

								if (grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] == 0) {
									grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] = grid[r][c];
									grid[r][c] = 0;
									change = true;

								}
							}

						}

					}
				}

				slide++;

			}

		}

		void slideDown(int n) {
			ArrayList<ArrayList<Integer>> neighbors;
			int slide = 0;
			while (slide < grid.length) {
				for (int r = grid.length - 1; r > -1; r--) {
					for (int c = 0; c < grid.length; c++) {
						if (grid[r][c] != 0) {
							neighbors = neighbors(r, c);

							if (inBounds(neighbors.get(n).get(0), neighbors.get(n).get(1))) {

								if (grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] == 0) {
									grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] = grid[r][c];
									grid[r][c] = 0;
									change = true;

								}
							}

						}

					}
				}

				slide++;

			}

			// merge

			for (int r = grid.length - 1; r > -1; r--) {
				for (int c = 0; c < grid.length; c++) {
					if (grid[r][c] != 0) {
						neighbors = neighbors(r, c);
						if (inBounds(neighbors.get(n).get(0), neighbors.get(n).get(1))) {
							if (grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] == grid[r][c]) {
								// if (merge.indexOf(new Location(r, c)) == -1) {
								grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] *= 2;
								grid[r][c] = 0;
								// merge.add(new Location(r, c - 1));
								change = true;

								// }

							}

						}
					}
				}
			}

			slide = 0;

			while (slide < grid.length) {
				for (int r = grid.length - 1; r > -1; r--) {
					for (int c = 0; c < grid.length; c++) {
						if (grid[r][c] != 0) {
							neighbors = neighbors(r, c);
							if (inBounds(neighbors.get(n).get(0), neighbors.get(n).get(1))) {

								if (grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] == 0) {
									grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] = grid[r][c];
									grid[r][c] = 0;
									change = true;

								}
							}

						}

					}
				}

				slide++;

			}

		}
		//
		void slideRight(int n) {
			ArrayList<ArrayList<Integer>> neighbors;
			int slide = 0;
			while (slide < grid.length) {
				for (int r = 0; r < grid.length; r++) {
					for (int c = grid.length - 1; c > -1; c--) {
						if (grid[r][c] != 0) {
							neighbors = neighbors(r, c);

							if (inBounds(neighbors.get(n).get(0), neighbors.get(n).get(1))) {

								if (grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] == 0) {
									grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] = grid[r][c];
									grid[r][c] = 0;
									change = true;

								}
							}

						}

					}
				}

				slide++;

			}

			// merge

			for (int r = 0; r < grid.length; r++) {
				for (int c = grid.length - 1; c > -1; c--) {
					if (grid[r][c] != 0) {
						neighbors = neighbors(r, c);
						if (inBounds(neighbors.get(n).get(0), neighbors.get(n).get(1))) {
							if (grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] == grid[r][c]) {
								// if (merge.indexOf(new Location(r, c)) == -1) {
								grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] *= 2;
								grid[r][c] = 0;
								// merge.add(new Location(r, c - 1));
								change = true;

								// }

							}

						}
					}
				}
			}

			slide = 0;

			while (slide < grid.length) {
				for (int r = 0; r < grid.length; r++) {
					for (int c = grid.length - 1; c > -1; c--) {
						if (grid[r][c] != 0) {
							neighbors = neighbors(r, c);
							if (inBounds(neighbors.get(n).get(0), neighbors.get(n).get(1))) {

								if (grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] == 0) {
									grid[neighbors.get(n).get(0)][neighbors.get(n).get(1)] = grid[r][c];
									grid[r][c] = 0;
									change = true;

								}
							}

						}

					}
				}

				slide++;

			}

		}

		private boolean inBounds(int r, int c) {
			if (r > -1 && r < grid.length && c > -1 && c < grid.length) {
				return true;
			}
			return false;
		}

		
		

	};

	public static void main(String[] args) {
		new GridBasedGameDriver().start();
	}

	void start() {
		setUpGameBoard();
		showGrid();
		world.show();// now the world is visible
	}

	private void setUpGameBoard() {
		world.setGrid(new BoundedGrid(this.NUM_ROWS, this.NUM_COLS));

		// randomly place 2 or 4

		random();
		random();

	}

	void random() {
		boolean notPlaced = true;
		while (notPlaced) {
			int random = (int) (Math.random() * 2);
			int tileNo = 0;
			if (random == 0) {
				tileNo = 2;
			} else {
				tileNo = 4;
			}
			int randomR = (int) (Math.random() * grid.length);
			int randomC = (int) (Math.random() * grid.length);

			if (grid[randomR][randomC] == 0) {
				grid[randomR][randomC] = tileNo;
				notPlaced = false;
			}

		}

	}

	void showGrid() {
		// for grid loop!
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid.length; c++) {
				if (grid[r][c] == 0) {
					world.add(new Location(r, c), new Board());
				} else if (grid[r][c] == 2) {
					world.add(new Location(r, c), new C2());
				} else if (grid[r][c] == 4) {
					world.add(new Location(r, c), new C4());
				} else if (grid[r][c] == 8) {
					world.add(new Location(r, c), new C8());
				} else if (grid[r][c] == 16) {
					world.add(new Location(r, c), new C16());
				} else if (grid[r][c] == 32) {
					world.add(new Location(r, c), new C32());
				} else if (grid[r][c] == 64) {
					world.add(new Location(r, c), new C64());
				} else if (grid[r][c] == 128) {
					world.add(new Location(r, c), new C128());
				} else if (grid[r][c] == 256) {
					world.add(new Location(r, c), new C256());
				} else if (grid[r][c] == 512) {
					world.add(new Location(r, c), new C512());
				} else if (grid[r][c] == 1024) {
					world.add(new Location(r, c), new C1024());
				} else if (grid[r][c] == 2048) {
					world.add(new Location(r, c), new C2048());
				}

			}
		}
	}

	// private void add2() {
	// int rCol = (int) (Math.random() * NUM_COLS), rRow = (int) (Math.random() *
	// NUM_ROWS);
	// Grid g = world.getGrid();
	// g.put(new Location(rRow, rCol), 2);
	// }
	//
	// private void add2or4() {
	// Grid g = world.getGrid();
	// ArrayList<Location> emptyLocs = new ArrayList();
	// for (int r = 0; r < this.NUM_ROWS; r++) {
	// for (int c = 0; c < this.NUM_COLS; c++) {
	// Location loc = new Location(r, c);
	// if (g.get(loc) == null) {
	// emptyLocs.add(loc);
	// }
	// }
	// }
	// if (emptyLocs.size() <= 0) {
	// gameOver();
	// return;
	// }
	//
	// // list wasn't empty
	// int index = (int) (Math.random() * emptyLocs.size());
	// Location loc = emptyLocs.get(index);
	// if (Math.random() >= .5)
	// g.put(loc, 2);
	// else
	// g.put(loc, 4);
	// }
	// void slideLeft() {
	// // ArrayList<Location> merge = new ArrayList<Location>();
	//
	// int slide = 0;
	// while (slide < grid.length) {
	// for (int r = 0; r < grid.length; r++) {
	// for (int c = 0; c < grid.length; c++) {
	// if (grid[r][c] != 0) {
	//
	// if (inBounds(r, c - 1)) {
	//
	// if (grid[r][c - 1] == 0) {
	// grid[r][c - 1] = grid[r][c];
	// grid[r][c] = 0;
	// change = true;
	//
	// }
	// }
	//
	// }
	//
	// }
	// }
	//
	// slide++;
	//
	// }
	//
	// // merge
	//
	// for (int r = 0; r < grid.length; r++) {
	// for (int c = 0; c < grid.length; c++) {
	// if (grid[r][c] != 0) {
	//
	// if (inBounds(r, c - 1)) {
	// if (grid[r][c - 1] == grid[r][c]) {
	// // if (merge.indexOf(new Location(r, c)) == -1) {
	// grid[r][c - 1] *= 2;
	// grid[r][c] = 0;
	// // merge.add(new Location(r, c - 1));
	// change = true;
	//
	// // }
	//
	// }
	//
	// }
	// }
	// }
	// }
	//
	// slide = 0;
	//
	// while (slide < grid.length) {
	// for (int r = 0; r < grid.length; r++) {
	// for (int c = 0; c < grid.length; c++) {
	// if (grid[r][c] != 0) {
	//
	// if (inBounds(r, c - 1)) {
	//
	// if (grid[r][c - 1] == 0) {
	// grid[r][c - 1] = grid[r][c];
	// grid[r][c] = 0;
	// change = true;
	//
	// }
	// }
	//
	// }
	//
	// }
	// }
	//
	// slide++;
	//
	// }
	//
	// }
	//
	// private void slideUp() {
	// ArrayList<Location> merge = new ArrayList<Location>();
	// int slide = 0;
	// while (slide < grid.length) {
	// for (int r = 0; r < grid.length; r++) {
	// for (int c = 0; c < grid.length; c++) {
	// if (grid[r][c] != 0) {
	//
	// if (inBounds(r - 1, c)) {
	//
	// if (grid[r - 1][c] == grid[r][c]) {
	// if (merge.indexOf(new Location(r, c)) == -1) {
	// grid[r - 1][c] *= 2;
	// grid[r][c] = 0;
	// merge.add(new Location(r - 1, c));
	// change = true;
	//
	// }
	//
	// } else if (grid[r - 1][c] == 0) {
	// grid[r - 1][c] = grid[r][c];
	// grid[r][c] = 0;
	// change = true;
	//
	// }
	// }
	//
	// }
	//
	// }
	// }
	//
	// slide++;
	//
	// }
	//
	// }
	//
	// private void slideDown() {
	// ArrayList<Location> merge = new ArrayList<Location>();
	// int slide = 0;
	// while (slide < grid.length) {
	// for (int r = grid.length - 1; r > -1; r--) {
	// for (int c = 0; c < grid.length; c++) {
	// if (grid[r][c] != 0) {
	//
	// if (inBounds(r + 1, c)) {
	//
	// if (grid[r + 1][c] == grid[r][c]) {
	// if (merge.indexOf(new Location(r, c)) == -1) {
	// grid[r + 1][c] *= 2;
	// grid[r][c] = 0;
	// merge.add(new Location(r + 1, c));
	// change = true;
	//
	// }
	//
	// } else if (grid[r + 1][c] == 0) {
	// grid[r + 1][c] = grid[r][c];
	// grid[r][c] = 0;
	// change = true;
	//
	// }
	// }
	//
	// }
	//
	// }
	// }
	// slide++;
	// }
	// }
	//
	// private void slideRight() {
	// ArrayList<Location> merge = new ArrayList<Location>();
	// int slide = 0;
	// while (slide < grid.length) {
	// for (int r = 0; r < grid.length; r++) {
	// for (int c = grid.length - 1; c > -1; c--) {
	// if (grid[r][c] != 0) {
	//
	// if (inBounds(r, c + 1)) {
	//
	// if (grid[r][c + 1] == grid[r][c]) {
	// if (merge.indexOf(new Location(r, c)) == -1) {
	// grid[r][c + 1] *= 2;
	// grid[r][c] = 0;
	// merge.add(new Location(r, c + 1));
	// change = true;
	//
	// }
	//
	// } else if (grid[r][c + 1] == 0) {
	// grid[r][c + 1] = grid[r][c];
	// grid[r][c] = 0;
	// change = true;
	//
	// }
	// }
	//
	// }
	//
	// }
	// }
	// slide++;
	// }
	// }

	private void gameOver() {

	}

}
