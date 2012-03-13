package de.jbee.fly.probability;

public abstract class RootScheme
		implements Scheme {

	protected final void uses( Class<? extends Scheme> scheme ) {
		// a Schema can use overrides to do relative changes like this: uses(otherschemasname); 
	}

	protected final void uses( String schemeName ) {

	}

	protected final Cohesion symbol( String name ) {
		return ref( Unit.SYMBOL, name );
	}

	protected final Cohesion term( String name ) {
		return ref( Unit.TERM, name );
	}

	protected final Cohesion fragment( String name ) {
		return ref( Unit.FRAGMENT, name );
	}

	@Override
	public void def( Unit unit, String name, Cohesion cohesion ) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cohesion ref( Unit unit, String name ) {
		// TODO Auto-generated method stub
		return null;
	}

}
