package entity;

public abstract class Entity {

	public int x, y;
	protected boolean removed = false;

	
	public boolean isRemoved() {
		return removed;
	}

	public void remove() {
		removed = true;
	}
}