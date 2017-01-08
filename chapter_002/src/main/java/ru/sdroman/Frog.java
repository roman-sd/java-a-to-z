package ru.sdroman;

/**
 * Class Frog.
 *
 * @author sdroman
 * @version 1.0
 * @since 29.12.16
 */
public class Frog {
    /**
     * Массив пути.
     */
    public Point[] resultWay;
    /**
     * Массив поля.
     */
    private int[][] board;
    /**
     * Счетчик позиции массива resultWay.
     */
    private int pos = 0;

    /**
     * Инициализация игрового поля.
     *
     * @param start  Point
     * @param finish Point
     * @param trees  Point[]
     */
    private void initBoard(Point start, Point finish, Point[] trees) {
        Point newFinish = convertFinishPoint(start, finish);
        board = new int[newFinish.getX() + 1][newFinish.getY() + 1];
        fillByTrees(start, trees);
        fillByZero();
    }

    /**
     * Инициализация массива пути от старта до финиша.
     *
     * @param x int
     * @param y int
     * @throws WayNotFoundException Exception
     */
    private void initResultArray(int x, int y) throws WayNotFoundException {
        resultWay = new Point[board[x][y]];
        if (board[x][y] > 0) {
            resultWay[pos++] = new Point(x, y, board[x][y]);
        } else {
            throw new WayNotFoundException("Way not found.");
        }
    }

    /**
     * Построение игрового поля волновым методом.
     *
     * @param startX  int
     * @param startY  int
     * @param count   int
     * @param finishX int
     * @param finishY int
     */
    private void buildBoard(int startX, int startY, int count, int finishX, int finishY) {
        if (!isInBoard(startX, startY) || board[startX][startY] == -1) {
            return;
        }
        if (board[startX][startY] == 0 && startX == finishX && startY == finishY) {
            board[startX][startY] = count + 1;
            return;
        }
        if ((board[startX][startY] == 0) || board[startX][startY] > count) {
            board[startX][startY] = count + 1;
        }
        buildBoard(startX - 2, startY + 1, count + 1, finishX, finishY);
        buildBoard(startX - 1, startY + 2, count + 1, finishX, finishY);
        buildBoard(startX, startY + 3, count + 1, finishX, finishY);
        buildBoard(startX + 1, startY + 2, count + 1, finishX, finishY);
        buildBoard(startX + 2, startY + 1, count + 1, finishX, finishY);
    }

    /**
     * Метод проверяющий находится ли точка в игровом поле.
     *
     * @param x int
     * @param y int
     * @return boolean
     */
    private boolean isInBoard(int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
    }

    /**
     * Метод строющий путь от финиша до старта.
     *
     * @param fX int
     * @param fY int
     */
    private void way(int fX, int fY) {

        if (isInBoard(fX - 2, fY - 1) && board[fX][fY] - 1 == board[fX - 2][fY - 1]) {
            resultWay[pos++] = new Point(fX - 2, fY - 1, board[fX - 2][fY - 1]);
            way(fX - 2, fY - 1);
        } else {
            if (isInBoard(fX - 1, fY - 2) && board[fX][fY] - 1 == board[fX - 1][fY - 2]) {
                resultWay[pos++] = new Point(fX - 1, fY - 2, board[fX - 1][fY - 2]);
                way(fX - 1, fY - 2);
            } else {
                if (isInBoard(fX, fY - 3) && board[fX][fY] - 1 == board[fX][fY - 3]) {
                    resultWay[pos++] = new Point(fX, fY - 3, board[fX][fY - 3]);
                    way(fX, fY - 3);
                } else {
                    if (isInBoard(fX + 1, fY - 2) && board[fX][fY] - 1 == board[fX + 1][fY - 2]) {
                        resultWay[pos++] = new Point(fX + 1, fY - 2, board[fX + 1][fY - 2]);
                        way(fX + 1, fY - 2);
                    } else {
                        if (isInBoard(fX + 2, fY - 1) && board[fX][fY] - 1 == board[fX + 2][fY - 1]) {
                            resultWay[pos++] = new Point(fX + 2, fY - 1, board[fX + 2][fY - 1]);
                            way(fX + 2, fY - 1);
                        }
                    }
                }
            }
        }
    }

    /**
     * Метод, преобразующий координаты финишной точки из прямоугольного поля
     * в круглое поле.
     *
     * @param start  Point
     * @param finish Point
     * @return Point
     */
    private Point convertFinishPoint(Point start, Point finish) {
        int sy = start.getY();
        int fy = finish.getY();
        int y;
        if (sy > fy) {
            y = 16 - sy + fy;
        } else {
            y = fy - sy;
        }
        return new Point(finish.getX(), y, 0);
    }

    /**
     * Метод, преобразующий координаты из прямоугольного поля в круглое поле.
     *
     * @param point Point
     * @param start Point
     * @return Point
     */
    private Point transformPoint(Point point, Point start) {
        int x = point.getX();
        int y = (point.getY() + start.getY()) % 16;
        return new Point(x, y, point.getValue());
    }

    /**
     * Метод, адаптирующий массив пути к координатам круглого поля.
     *
     * @param start Point
     * @return Point[]
     */
    public Point[] resultArray(Point start) {
        Point[] result = new Point[resultWay.length];
        for (int i = 0; i < resultWay.length; i++) {
            result[i] = transformPoint(resultWay[i], start);
        }
        return result;
    }

    /**
     * Метод, наполняющий массива поля нулями.
     */
    private void fillByZero() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != -1) {
                    board[i][j] = 0;
                }
            }
        }
    }

    /**
     * Метод заполнения деревьями поля.
     *
     * @param start Point
     * @param trees Point[]
     */
    private void fillByTrees(Point start, Point[] trees) {
        for (Point tree : trees) {
            Point tmp = convertFinishPoint(start, tree);
            board[tmp.getX()][tmp.getY()] = -1;
        }
    }

    /**
     * Начало работы.
     *
     * @param start  Point
     * @param finish Point
     * @param trees  Point[]
     * @throws WayNotFoundException Exception
     */
    public void init(Point start, Point finish, Point[] trees) throws WayNotFoundException {

        initBoard(start, finish, trees);
        Point fin = convertFinishPoint(start, finish);
        buildBoard(start.getX(), 0, 0, fin.getX(), fin.getY());
        initResultArray(fin.getX(), fin.getY());
        way(fin.getX(), fin.getY());
    }
}
