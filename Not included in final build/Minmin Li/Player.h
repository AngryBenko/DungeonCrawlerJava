using namespace std;
#ifndef GAME_H_INCLUDED
#define GAME_H_INCLUDED
#include<string>
const int A = 4;

class Player {
private:
	string name;
	bool life;
	int blood;
	Weapon weapons[A];
	int weaponNum;     
	int holdWeapon;
	Point location;  
	
public:
	Player(string nam, int b, Weapon w[], int n);
	~Player(); 
	void eat(int d); 
	void attack(Player &r);
	void beAttack(int f);
	bool isAlived(); 
	void changeWeapon(int wno); 	
	void moveTo(int x, int y); 
	void move(int dx, int dy); 

};
class Point     
{
public: 
	Point(int x = 0, int y = 0);
	int getX();
	int getY();
	double distance(const Point &p);  
	void moveTo(int x, int y); 
	void move(int dx, int dy);
private:
	int x, y;  
};

class Weapon
{private:
	string wname;   
	int force;       
	double killRange;  
public:
	Weapon() {};
	Weapon(string wnam, int f, double k);
	string getWname();
	int getForce();         
	double getKillRange();  

};

#endif // GAME_H_INCLUDED