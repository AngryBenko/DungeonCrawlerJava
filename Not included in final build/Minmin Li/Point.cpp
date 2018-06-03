#include "Player.h"
#include <cmath>

Point::Point(int x, int y) : x(x), y(y) { }
int Point::getX()
{
	return x;
}
int Point::getY()
{
	return y;
}

void Point::moveTo(int x, int y)
{
	this->x = x;
	this->y = y;
}
void Point::move(int dx, int dy)
{
	this->x += dx;
	this->y += dy;
}
double Point::distance(const Point& p)
{
	double dx = this->x - p.x;
	double dy = this->y - p.y;
	return (sqrt(dx * dx + dy * dy));
}