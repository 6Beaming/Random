import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomTest {

    @Test
    void testDistance1() {
    	// Test the same point
        Point p = new Point(0, 0);
        assertEquals(0.0, p.distance(p)); // Excepted: 0.0, Actual: p.distacne(p)
    }

    @Test
    void testDistance2() {
    	// Test different points
        Point p1 = new Point(2, 0);
        Point p2 = new Point(5, 4);
        assertEquals(5.0, p1.distance(p2)); // Excepted: 5.0, Actual: p.distacne(p2)
    }

    @Test
    void testHashCode1() {
        Point p = new Point(2.5, 3.5);
        assertEquals((int)(3*2.5 + 5*3.5), p.hashCode()); // Excepted: (int)(3*2.5 + 5*3.5), Actual: p.hashCode()
    }
    
    @Test
    void testHashCode2() {
    	// Test if two equal points (same values, different reference) have the same hashCode
        Point p = new Point(2.5, 3.5);
        Point q = new Point(2.5, 3.5);
        assertEquals(p.hashCode(), q.hashCode()); // Equal objects have the same hashCode
    }
    
    @Test
    void testEquals1() {
    	// Test the same reference: if (this == obj) return true;
        Point p = new Point(1.5, 2);
        assertTrue(p.equals(p));  // Pass if p.equals(p) is true
    }

    @Test
    void testEquals2() {
    	// Test between a object and null: if (obj == null) return false;
        Point p = new Point(2, 2);
        assertFalse(p.equals(null)); // Pass if p.equals(null) is false
    }

    @Test
    void testEquals3() {
    	// Test between a object and a different class: if (getClass() != obj.getClass()) return false;
        Point p = new Point(5, 8);
        assertFalse(p.equals(520)); // Pass if p.equals(520) is false -- 520 is int class not a Point class
    }

    @Test
    void testEquals4() {
    	// Test with different x of points: if (x != other.x) return false;
        Point p1 = new Point(5, 2);
        Point p2 = new Point(3, 2);
        assertFalse(p1.equals(p2)); // Pass if p1.equals(p2) is false -- 5!=3
    }

    @Test
    void testEquals5() {
    	// Test with different y of points: if (y != other.y) return false;
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 3);
        assertFalse(p1.equals(p2)); // Pass if p1.equals(p2) is false -- 1==1 but 2!=3
    }

    @Test
    void testEquals6() {
    	// Test the true case
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        assertTrue(p1.equals(p2)); // Pass if p1.equals(p2) is true
    }


    // Tests for Triangle class

    @Test
    void testPerimeter() {
        Point a = new Point(0, 0);
        Point b = new Point(3, 0);
        Point c = new Point(0, 4);
        Triangle t = new Triangle(a, b, c);
        assertEquals(12.0, t.perimeter());
    }

    @Test
    void testIsEquilateral1() {
    	// Test the true case
        Point p1 = new Point(0, 0);
        Point p2 = new Point(Math.sqrt(5), 0);
        Point p3 = new Point(Math.sqrt(5)/2, Math.sqrt(15)/2);
        Triangle t = new Triangle(p1, p2, p3);
        assertTrue(t.isEquilateral()); // Pass if t is a Equilateral
    }

    @Test
    void testIsEquilateral2() {
    	// Test the false case
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(0, 1);
        Triangle t = new Triangle(p1, p2, p3);
        assertFalse(t.isEquilateral()); // Pass if t is not a Equilateral
    }

}