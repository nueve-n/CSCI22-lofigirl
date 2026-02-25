/**
    The GirlArms class manages the rendering and animation of the girl's arms and hands.
    It implements AffineTransform logic to make arm movements synced with the character's breathing while simulating typing motion.

    @author Fiona Nadine Macalalag (253550)
    @author John Carlo Ranario (254815)
    @version February 26, 2026

    We have not discussed the Java language code in my program
    with anyone other than our instructor or the teaching assistants
    assigned to this course.

    We have not used Java language code obtained from another student,
    or any other unauthorized source, either modified or unmodified.
    
    If any Java language code or documentation used in our program
    was obtained from another source, such as a textbook or website,
    that has been clearly noted with a proper citation in the comments
    of my program.
*/

import java.awt.*;
import java.awt.geom.*;

public class GirlArms implements DrawingObject {
    static double baseWidth = 625.4;
    static double baseHeight = 1291.3;
    static double baseX = 67.9;
    static double baseY = 35;
    double x, y, w, h;
    Color sweaterC, sweaterShadowC, skinC, skinShadowC;
    double breathProgress = 0;
    double breathSpeed = 0.09;
    double typingProgress = 0;
    double typingSpeed = 1;

    /**
        Constructs the GirlArms object with specified positions and a color palette.
        @param x The x-coordinate for the arms.
        @param y The y-coordinate for the arms.
        @param w The width of the arms component.
        @param h The height of the arms component.
        @param sweaterC The main color of the sweater sleeves.
        @param sweaterShadowC The color for the shadowed parts of the sleeves.
        @param skinC The main skin color for the hands.
        @param skinShadowC The shadow color for the hands.
    */
    public GirlArms(
        double x, double y, double w, double h, 
        Color sweaterC, Color sweaterShadowC, Color skinC, Color skinShadowC) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.sweaterC = sweaterC;
        this.sweaterShadowC = sweaterShadowC;
        this.skinC = skinC;
        this.skinShadowC = skinShadowC;
    }
    
    /**
        Renders the arms and hands using stacked AffineTransforms.
        It handles the translation for breathing and the rotation for the typing animation.
        @param g2d The Graphics2D object used for drawing.
    */
    @Override 
    public void draw(Graphics2D g2d) {
        Path2D.Double sleeveUpper1 = new Path2D.Double();
        sleeveUpper1.moveTo(188.9, 555.5);
        sleeveUpper1.quadTo(241.8, 626.4, 306.4, 681.7);
        sleeveUpper1.quadTo(340.6, 691.4, 376.8, 695.3);
        sleeveUpper1.quadTo(385.5, 640.9, 396.2, 572.9);
        sleeveUpper1.quadTo(364.2, 592.4, 277.7, 464.2);
        sleeveUpper1.closePath();

        Path2D.Double sleeveUpper2 = new Path2D.Double();
        sleeveUpper2.moveTo(310.7, 378.7);
        sleeveUpper2.quadTo(380.7, 504.0, 417.1, 493.3);
        sleeveUpper2.quadTo(411.5, 539.9, 409.8, 584.6);
        sleeveUpper2.quadTo(386.5, 581.7, 363.2, 578.8);
        sleeveUpper2.quadTo(316.6, 527.3, 290.0, 520.8);
        sleeveUpper2.closePath();
        
        Path2D.Double sleeveLower2 = new Path2D.Double();
        sleeveLower2.moveTo(417.1,495.3);
        sleeveLower2.quadTo(514.7, 532.2, 653.1, 557.4);
        sleeveLower2.quadTo(622.2, 587.5, 640.4, 617.6);
        sleeveLower2.quadTo(498.2, 596.3, 380.7, 576.8);
        sleeveLower2.closePath();

        Path2D.Double sleeveLower1 = new Path2D.Double();
        sleeveLower1.moveTo(367.6, 569.1);
        sleeveLower1.quadTo(498.2, 591.4, 660.8, 612.6);
        sleeveLower1.quadTo(621.3, 657.4, 648.2, 690.9);
        sleeveLower1.quadTo(389.4, 705.0, 306.4, 681.7);
        sleeveLower1.closePath();
        
        Path2D.Double hand1 = new Path2D.Double();
        hand1.moveTo(599.0, 679.0);
        hand1.quadTo(646.3, 684.4, 709.7, 666.7);
        hand1.quadTo(733.2, 673.0, 761.3, 669.8);
        hand1.quadTo(780.3, 648.9, 719.4, 606.3);
        hand1.quadTo(710.5, 600.9, 604.3, 630.5);
        hand1.closePath();

        Path2D.Double hand2 = new Path2D.Double();
        hand2.moveTo(606.3, 604.1);
        hand2.quadTo(655.2, 613.5, 714.1, 589.7);
        hand2.quadTo(736.8, 601.3, 755.1, 599.6);
        hand2.quadTo(774.5, 581.3, 711.8, 555.2);
        hand2.quadTo(695.7, 551.9, 610.7, 569.7);
        hand2.closePath();

        AffineTransform at = new AffineTransform();

        at.translate(x, y);
        at.scale(w/baseWidth, h/baseHeight);
        at.translate(-baseX, -baseY);

        double breathMultiplier = (Math.sin(breathProgress) + 1) / 2;
        double breatheShift = -18 * breathMultiplier;

        AffineTransform sweaterSleeveAT = new AffineTransform(at);

        sweaterSleeveAT.translate(0, 600);
        sweaterSleeveAT.translate(0, breatheShift * 0.75);        
        sweaterSleeveAT.translate(0, -600);

        double typingMultiplier = Math.sin(typingProgress);

        AffineTransform typingRightAT = new AffineTransform(sweaterSleeveAT);

        typingRightAT.translate(613.7, 701.1);
        typingRightAT.rotate(Math.toRadians(5 * typingMultiplier));
        typingRightAT.translate(-613.7, -701.1);

        AffineTransform typingLeftAT = new AffineTransform(sweaterSleeveAT);

        typingLeftAT.translate(613.7, 701.1);
        typingLeftAT.rotate(Math.toRadians(-5 * typingMultiplier));
        typingLeftAT.translate(-613.7, -701.1);

        g2d.setColor(skinC);
        g2d.fill(typingLeftAT.createTransformedShape(hand2));
        g2d.setColor(skinShadowC);
        g2d.fill(typingRightAT.createTransformedShape(hand1));

        g2d.setColor(sweaterC);
        g2d.fill(sweaterSleeveAT.createTransformedShape(sleeveUpper2));
        g2d.fill(sweaterSleeveAT.createTransformedShape(sleeveLower2));
        g2d.setColor(sweaterShadowC);
        g2d.fill(sweaterSleeveAT.createTransformedShape(sleeveUpper1));
        g2d.fill(sweaterSleeveAT.createTransformedShape(sleeveLower1));
    }

    /**
        Updates the progress for breathing and typing animations.
        This method is called within SceneFrame.
    */
    public void animate() {
        breathProgress += breathSpeed;
        typingProgress += typingSpeed;
    }
}

/*
REFERENCES:
    1. CodingTechRoom. "Affine Transform Scale Center Java." https://codingtechroom.com/question/-affine-transform-scale-center-java
    2. CodingTechRoom. "Java Graphics2D Translate Scale." https://codingtechroom.com/question/java-graphics2d-translate-scale
    3. GeeksforGeeks. "Java Math sin() method with Examples." https://www.geeksforgeeks.org/java/java-math-sin-method-examples/
    4. JavaThinking. "Rotating Image with AffineTransform." https://www.javathinking.com/blog/rotating-image-with-affinetransform/
    5. Coordinate tracing tool for shapes created by Marxus Magisa.
*/
