package fr.fireowls.spaceowls.utils;

import java.util.NoSuchElementException;

public class Pile<E> {

	private E[] contenu;
	private int tailleMax;
	private int sommet;
	
	@SuppressWarnings("unchecked")
	public Pile(int taille) {
		this.contenu = (E[]) new Object[taille];
		this.tailleMax = taille;
		this.sommet = -1;
	}
	
	public boolean isEmpty() {
	    return sommet == -1;
	  }

	  public boolean isFull() {
	    return sommet == tailleMax - 1;
	  }

	  public void push(E t) {
	    if (isFull()) {
	      throw new IllegalStateException();
	    }
	    contenu[++ sommet] = t;
	  }

	  public E pop() {
	    if (isEmpty()) {
	      throw new NoSuchElementException();
	    }
	    return contenu[sommet --];
	  }

	  public E peek() {
	    if (isEmpty()) {
	      throw new NoSuchElementException();
	    }
	    return contenu[sommet];
	  }
	
}
