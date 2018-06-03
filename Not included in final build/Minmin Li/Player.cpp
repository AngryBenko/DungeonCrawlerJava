
#include <iostream>
#include "Player.h"
using namespace std;


Player::Player(string nam, int b, Weapon w[],int n)
	:name(nam), blood(b),  weaponNum(n), holdWeapon(NOWEAPON)
{
	if (blood>0)
		life = true;
	else
		life = false;
	for (int i = 0; i<n; i++)
		weapons[i] = w[i];
}
Player::~Player()
{
	cout << "Bye"<<name <<  endl;
}


void Player::eat(int d)
{
	blood += d;
	if (blood>0)
		life = true;
}


void Player::attack(Player &r)
{
	if (isAlived() && holdWeapon>NOWEAPON&&weapons[holdWeapon].getKillRange()>this->distance(r)) 
	{
		blood += weapons[holdWeapon].getForce();
		r.beAttack(weapons[holdWeapon].getForce());
	}
}


void Player::beAttack(int f)
{
	blood -= f;
	if (blood <= 0)
		life = false;
}

void Player::changeWeapon(int wno)
{
	if (wno<weaponNum)
		holdWeapon = wno;
}

bool Player::isAlived()
{
	return life;
}
void Player::moveTo(int x, int y)
{
	if (isAlived())  
		location.moveTo(x, y);
}

void Player::move(int dx, int dy)
{
	if (isAlived())
		location.move(dx, dy);
}