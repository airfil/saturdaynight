package org.academiadecodigo.enuminatti.saturdaynight;

/**
 * Created by codecadet on 09/10/17.
 */
public interface Collidable {

    public boolean coolided =false;


    public abstract void whenCollisionHappens();



    abstract public void CrashCheck(Collidable myCollideble);

}
