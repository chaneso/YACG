package Game;

import java.util.ArrayList;
import java.util.Stack;

public class Field {
	private ArrayList<Pernament> field;
	private Stack<Card> stack;

	public Field() {
		super();
		this.field = new ArrayList<Pernament>();
		this.stack = new Stack<Card>();
	}

	public void ispisTableIgraca(Player igrac) {
		System.out.println("Filed:");
		for (Pernament ele : field) {
			if (ele.getimeVlasnika().equals(igrac.getIme())) {
				System.out.println(ele);
			}
		}
	}

	public void ispisStack() {
		System.out.println("Stack:");
		for (Card ele : stack) {
			System.out.println(ele);
		}
	}
	
	public void addCardToField(Pernament a) {
		field.add(a);
	}
	
	public boolean popStack() {
		if (stack.size() > 0) {
			Card a = stack.pop();
			if (a instanceof Pernament) {
				field.add((Pernament) a);
			}
			if (a.getEffect() != null) {
				a.getEffect().activate();
			}
			return true;
		}
		return false;
	}

	public void castSpell(Card spell) {
		stack.add(spell);
	}

	public boolean cardOnField(Card card) {
		for (Pernament element : field) {
			if (element == card) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Pernament> getField() {
		return field;
	}

	public void setField(ArrayList<Pernament> field) {
		this.field = field;
	}

	public Stack<Card> getStack() {
		return stack;
	}

	public void setStack(Stack<Card> stack) {
		this.stack = stack;
	}

	public boolean isStackEmpty() {
		if (stack.size() == 0) {
			return true;
		}
		return false;
	}

}