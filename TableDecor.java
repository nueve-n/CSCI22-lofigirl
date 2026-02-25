/**
    The TableDecor class represents various items on the table, including
    stacked books, loose papers, and a mobile phone. It uses Path2D shapes 
    and an AffineTransform to render these detailed elements.

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

public class TableDecor implements DrawingObject {
    double x, y, w, h;
    static double baseX = 67.3;
    static double baseY = 232.8;
    static double baseWidth = 515.1;
    static double baseHeight = 184.0;
    Color pagesC, pagesShadowC, book1C, book1ShadowC, book2C, book3C, book4C, book4ShadowC, book5C, book5ShadowC, phoneC, phoneShadowC;

    /**
        Constructs TableDecor with specified positions and a detailed color palette for the items.
        @param x The x-coordinate of the decorations.
        @param y The y-coordinate of the decorations.
        @param w The width to scale the decorations to.
        @param h The height to scale the decorations to.
        @param pagesC The color for book pages and paper.
        @param pagesShadowC The shadow color for paper.
        @param book1C Primary color for the first book.
        @param book1ShadowC Shadow color for the first book.
        @param book2C Color for the second book.
        @param book3C Color for the third book.
        @param book4C Color for the fourth book.
        @param book4ShadowC Shadow color for the fourth book.
        @param book5C Color for the fifth book.
        @param book5ShadowC Shadow color for the fifth book.
        @param phoneC Primary color for the phone.
        @param phoneShadowC Shadow color for the phone side.
    */
    public TableDecor(
            double x, double y, double w, double h,
            Color pagesC, Color pagesShadowC,
            Color book1C, Color book1ShadowC,
            Color book2C,
            Color book3C,
            Color book4C, Color book4ShadowC,
            Color book5C, Color book5ShadowC,
            Color phoneC, Color phoneShadowC
    ) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        this.pagesC = pagesC;
        this.pagesShadowC = pagesShadowC;
        this.book1C = book1C;
        this.book1ShadowC = book1ShadowC;
        this.book2C = book2C;
        this.book3C = book3C;
        this.book4C = book4C;
        this.book4ShadowC = book4ShadowC;
        this.book5C = book5C;
        this.book5ShadowC = book5ShadowC;
        this.phoneC = phoneC;
        this.phoneShadowC = phoneShadowC;
    }

    /**
        Renders the table decorations using an AffineTransform for scaling and positioning.
        @param g2d The Graphics2D object used for rendering.
    */
    @Override 
    public void draw(Graphics2D g2d) {

        Path2D.Double book1Top = new Path2D.Double();
        book1Top.moveTo(459.3, 232.8);
        book1Top.lineTo(335.0, 240.4);
        book1Top.lineTo(471.7, 250.7);
        book1Top.lineTo(557.9, 244.2);
        book1Top.closePath();

        Path2D.Double book1Side = new Path2D.Double();
        book1Side.moveTo(552.3, 271.9);
        book1Side.quadTo(567.9, 257.4, 553.8, 241.7);
        book1Side.quadTo(512.3, 244.9, 470.8, 248.1);
        book1Side.quadTo(401.6, 244.2, 332.3, 240.4);
        book1Side.quadTo(332.5, 242.4, 332.6, 245.2);
        book1Side.quadTo(399.4, 248.9, 468.6, 253.1);
        book1Side.quadTo(480.2, 270.5, 464.4, 279.5);
        book1Side.quadTo(398.6, 272.6, 332.8, 265.7);
        book1Side.quadTo(332.6, 268.0, 332.3, 270.4);
        book1Side.quadTo(394.2, 276.9, 463.5, 284.0);
        book1Side.closePath();

        Path2D.Double book1Pages = new Path2D.Double();
        book1Pages.moveTo(334.8, 244.0);
        book1Pages.quadTo(342.2, 256.3, 333.0, 268.9);
        book1Pages.quadTo(399.7, 272.7, 463.3, 282.1);
        book1Pages.quadTo(478.7, 270.0, 466.8, 249.5);
        book1Pages.closePath();

        Path2D.Double book2Cover = new Path2D.Double();
        book2Cover.moveTo(546.8, 266.7);
        book2Cover.quadTo(483.7, 271.6, 420.7, 276.4);
        book2Cover.quadTo(443.4, 281.9, 466.0, 287.3);
        book2Cover.quadTo(516.0, 284.7, 566.0, 282.1);
        book2Cover.quadTo(574.8, 288.7, 564.6, 292.6);
        book2Cover.quadTo(513.0, 295.1, 461.5, 297.6);
        book2Cover.quadTo(399.5, 287.9, 337.5, 278.1);
        book2Cover.quadTo(333.2, 278.6, 337.4, 280.7);
        book2Cover.quadTo(399.4, 290.9, 461.4, 301.0);
        book2Cover.quadTo(513.2, 298.6, 564.9, 296.2);
        book2Cover.quadTo(582.4, 292.9, 569.2, 275.9);
        book2Cover.closePath();

        Path2D.Double book2Pages = new Path2D.Double();
        book2Pages.moveTo(336.1, 278.5);
        book2Pages.quadTo(340.0, 274.8, 339.3, 267.3);
        book2Pages.quadTo(403.1, 276.4, 466.8, 285.5);
        book2Pages.quadTo(516.4, 282.8, 565.9, 280.1);
        book2Pages.quadTo(576.1, 287.5, 564.4, 293.3);
        book2Pages.quadTo(512.0, 296.7, 459.6, 300.0);
        book2Pages.closePath();

        Path2D.Double book4Side = new Path2D.Double();
        book4Side.moveTo(400.7, 327.5);
        book4Side.quadTo(389.8, 336.5, 398.1, 345.9);
        book4Side.quadTo(473.9, 340.6, 549.8, 335.3);
        book4Side.quadTo(549.8, 337.0, 549.8, 338.7);
        book4Side.quadTo(473.4, 344.0, 396.9, 349.2);
        book4Side.quadTo(373.5, 335.2, 349.2, 322.6);
        book4Side.quadTo(346.2, 309.8, 355.3, 303.8);
        book4Side.closePath();

        Path2D.Double book4Top = new Path2D.Double();
        book4Top.moveTo(479.6, 301.1);
        book4Top.lineTo(352.6, 301.9);
        book4Top.lineTo(392.7, 324.1);
        book4Top.lineTo(552.5, 318.1);
        book4Top.closePath();

        Path2D.Double book4Pages = new Path2D.Double();
        book4Pages.moveTo(395.8, 324.5);
        book4Pages.quadTo(387.7, 336.5, 397.3, 347.4);
        book4Pages.quadTo(462.7, 343.2, 546.4, 336.8);
        book4Pages.quadTo(540.0, 324.8, 547.9, 316.2);
        book4Pages.closePath();

        Path2D.Double book3Cover = new Path2D.Double();
        book3Cover.moveTo(566.7, 290.7);
        book3Cover.quadTo(567.6, 294.4, 564.8, 298.2);
        book3Cover.quadTo(520.1, 301.0, 475.4, 303.8);
        book3Cover.quadTo(469.2, 308.7, 472.0, 312.8);
        book3Cover.quadTo(518.6, 310.2, 565.2, 307.6);
        book3Cover.quadTo(566.3, 309.6, 564.4, 310.9);
        book3Cover.quadTo(512.4, 313.8, 460.4, 316.6);
        book3Cover.quadTo(402.2, 306.1, 344.0, 295.5);
        book3Cover.quadTo(340.6, 288.4, 345.5, 279.0);
        book3Cover.closePath();

        Path2D.Double book3Pages = new Path2D.Double();
        book3Pages.moveTo(560.2, 309.1);
        book3Pages.quadTo(559.2, 304.2, 560.3, 297.8);
        book3Pages.quadTo(511.5, 299.5, 462.7, 301.2);
        book3Pages.quadTo(461.9, 307.7, 461.1, 314.3);
        book3Pages.closePath();

        Path2D.Double book5Top = new Path2D.Double();
        book5Top.moveTo(501.5, 334.2);
        book5Top.lineTo(350.1, 332.8);
        book5Top.lineTo(453.2, 356.7);
        book5Top.lineTo(560.5, 351.3);
        book5Top.closePath();

        Path2D.Double book5Side = new Path2D.Double();
        book5Side.moveTo(342.7, 381.3);
        book5Side.quadTo(326.7, 353.5, 350.4, 332.5);
        book5Side.quadTo(402.1, 345.0, 453.8, 357.5);
        book5Side.quadTo(507.4, 352.4, 561.1, 347.3);
        book5Side.quadTo(561.1, 349.1, 561.1, 351.0);
        book5Side.quadTo(506.6, 356.1, 452.1, 361.2);
        book5Side.quadTo(402.1, 349.0, 352.1, 336.8);
        book5Side.quadTo(331.8, 357.6, 346.4, 378.2);
        book5Side.quadTo(395.0, 391.4, 443.8, 405.5);
        book5Side.quadTo(502.2, 400.9, 560.5, 396.4);
        book5Side.quadTo(560.7, 399.0, 560.2, 399.5);
        book5Side.quadTo(502.5, 406.8, 443.5, 408.9);
        book5Side.closePath();
        
        Path2D.Double book5Pages = new Path2D.Double();
        book5Pages.moveTo(559.4, 399.5);
        book5Pages.quadTo(499.8, 403.2, 440.1, 406.9);
        book5Pages.quadTo(390.2, 393.1, 340.2, 379.4);
        book5Pages.quadTo(345.0, 357.1, 349.8, 334.8);
        book5Pages.quadTo(400.7, 346.8, 451.5, 358.9);
        book5Pages.quadTo(503.7, 354.5, 556.0, 350.1);
        book5Pages.closePath();

        Path2D.Double paper1 = new Path2D.Double();
        paper1.moveTo(100.4, 417.3);
        paper1.lineTo(111.8, 371.0);
        paper1.lineTo(302.2, 361.3);
        paper1.lineTo(334.6, 405.6);
        paper1.closePath();

        Path2D.Double paper2 = new Path2D.Double();
        paper2.moveTo(241.7, 333.6);
        paper2.lineTo(153.8, 352.7);
        paper2.lineTo(148.9, 396.6);
        paper2.lineTo(296.7, 354.6);
        paper2.closePath();

        Path2D.Double phoneTop = new Path2D.Double();
        phoneTop.moveTo(190.3, 414.9);
        phoneTop.quadTo(194.4, 416.5, 195.1, 419.8);
        phoneTop.quadTo(192.8, 428.6, 190.5, 437.4);
        phoneTop.quadTo(187.7, 442.0, 183.2, 442.8);
        phoneTop.quadTo(127.5, 441.1, 71.8, 439.4);
        phoneTop.quadTo(68.4, 437.4, 69.0, 433.1);
        phoneTop.quadTo(74.3, 424.6, 79.5, 416.1);
        phoneTop.quadTo(82.5, 412.7, 87.2, 412.1);
        phoneTop.closePath();

        Path2D.Double phoneSide = new Path2D.Double();
        phoneSide.moveTo(192.5, 413.0);
        phoneSide.quadTo(197.3, 423.3, 197.7, 428.0);
        phoneSide.quadTo(194.5, 437.4, 191.4, 446.7);
        phoneSide.quadTo(189.0, 451.8, 183.2, 451.8);
        phoneSide.quadTo(127.5, 449.9, 71.8, 447.9);
        phoneSide.quadTo(67.3, 447.0, 67.3, 442.2);
        phoneSide.quadTo(68.0, 435.0, 72.7, 439.4);
        phoneSide.quadTo(127.6, 441.3, 182.6, 443.3);
        phoneSide.quadTo(185.7, 442.0, 190.0, 436.5);
        phoneSide.closePath();

        AffineTransform at = new AffineTransform();

        at.translate(x, y);
        at.scale(w/baseWidth, h/baseHeight);
        at.translate(-baseX, -baseY);

        g2d.setColor(pagesC);
        g2d.fill(at.createTransformedShape(book5Pages));

        g2d.setColor(book5ShadowC);
        g2d.fill(at.createTransformedShape(book5Side));
        
        g2d.setColor(book5C);
        g2d.fill(at.createTransformedShape(book5Top));
        
        g2d.setColor(pagesC);
        g2d.fill(at.createTransformedShape(book4Pages));
        
        g2d.setColor(book4ShadowC);
        g2d.fill(at.createTransformedShape(book4Side));
        
        g2d.setColor(book4C);
        g2d.fill(at.createTransformedShape(book4Top));     

        g2d.setColor(pagesC);
        g2d.fill(at.createTransformedShape(book3Pages));
        
        g2d.setColor(book3C);
        g2d.fill(at.createTransformedShape(book3Cover)); 

        g2d.setColor(pagesC);
        g2d.fill(at.createTransformedShape(book2Pages));
        
        g2d.setColor(book2C);
        g2d.fill(at.createTransformedShape(book2Cover)); 

        g2d.setColor(pagesC);
        g2d.fill(at.createTransformedShape(book1Pages));
        
        g2d.setColor(book1ShadowC);
        g2d.fill(at.createTransformedShape(book1Side));
        
        g2d.setColor(book1C);
        g2d.fill(at.createTransformedShape(book1Top));  
        
        g2d.setColor(pagesC);
        g2d.fill(at.createTransformedShape(paper1));
        
        g2d.setColor(pagesShadowC);
        g2d.fill(at.createTransformedShape(paper2));
                
        g2d.setColor(phoneShadowC);
        g2d.fill(at.createTransformedShape(phoneSide));

        g2d.setColor(phoneC);
        g2d.fill(at.createTransformedShape(phoneTop));
    }
}

/**
REFERENCES:
    1. CodingTechRoom. "How to Scale a Shape from Its Center Using AffineTransform in Java." https://codingtechroom.com/question/-affine-transform-scale-center-java
    2. CodingTechRoom. "How to Translate and Scale Graphics Using Java's Graphics2D?." https://codingtechroom.com/question/java-graphics2d-translate-scale
    3. Coordinate tracing tool for shapes created by Marxus Magisa.
*/