/*
 * Copyright (C) 2003 - 2008
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package net.sourceforge.cilib.container.visitor;

/**
 * Extension of the default {@linkplain Visitor} to make pre and post visit operations
 * possible.
 * <p>
 * An example of use would be on {@linkplain Tree} containers, whereby the specific
 * traversal would alter the order in which tree nodes are used.
 * 
 * @author Gary Pampara
 * @param <E> The element type.
 */
public class PrePostVisitor<E> extends Visitor<E> {
	
	/**
	 * Create a new instance of {@linkplain PrePostVisitor}.
	 */
	public PrePostVisitor() {
	}
	
	/**
	 * Pre-visit the given element.
	 * @param o The object to pre-visit.
	 */
	public void preVisit(E o) {};
	
	/**
	 * {@inheritDoc}
	 */
	public void visit(E o) {};
	
	/**
	 * Post-visit the given element.
	 * @param o The element to post visit.
	 */
	public void postVisit(E o) {};
}
