package fr.fireowls.spaceowls.screen;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Affine;

public class OwlPainter {

    private GraphicsContext graphicsContext;
    private Camera camera;

    public OwlPainter(GraphicsContext graphicsContext, Camera camera) {
        this.graphicsContext = graphicsContext;
        this.camera = camera;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Camera getCamera() {
        return camera;
    }

    public Canvas getCanvas() {
        return graphicsContext.getCanvas();
    }

    public void save() {
        graphicsContext.save();
    }

    public void restore() {
        graphicsContext.restore();
    }

    public void translate(double x, double y) {
        graphicsContext.translate(x, y);
    }

    public void scale(double x, double y) {
        graphicsContext.scale(x, y);
    }

    public void rotate(double degrees) {
        graphicsContext.rotate(degrees);
    }

    public void transform(double mxx, double myx, double mxy, double myy, double mxt, double myt) {
        graphicsContext.transform(mxx, myx, mxy, myy, mxt, myt);
    }

    public void transform(Affine xform) {
        graphicsContext.transform(xform);
    }

    public void setTransform(double mxx, double myx, double mxy, double myy, double mxt, double myt) {
        graphicsContext.setTransform(mxx, myx, mxy, myy, mxt, myt);
    }

    public void setTransform(Affine xform) {
        graphicsContext.setTransform(xform);
    }

    public Affine getTransform(Affine xform) {
        return graphicsContext.getTransform(xform);
    }

    public Affine getTransform() {
        return graphicsContext.getTransform();
    }

    public void setGlobalAlpha(double alpha) {
        graphicsContext.setGlobalAlpha(alpha);
    }

    public double getGlobalAlpha() {
        return graphicsContext.getGlobalAlpha();
    }

    public void setGlobalBlendMode(BlendMode op) {
        graphicsContext.setGlobalBlendMode(op);
    }

    public BlendMode getGlobalBlendMode() {
        return graphicsContext.getGlobalBlendMode();
    }

    public void setFill(Paint p) {
        graphicsContext.setFill(p);
    }

    public Paint getFill() {
        return graphicsContext.getFill();
    }

    public void setStroke(Paint p) {
        graphicsContext.setStroke(p);
    }

    public Paint getStroke() {
        return graphicsContext.getStroke();
    }

    public void setLineWidth(double lw) {
        graphicsContext.setLineWidth(lw);
    }

    public double getLineWidth() {
        return graphicsContext.getLineWidth();
    }

    public void setLineCap(StrokeLineCap cap) {
        graphicsContext.setLineCap(cap);
    }

    public StrokeLineCap getLineCap() {
        return graphicsContext.getLineCap();
    }

    public void setLineJoin(StrokeLineJoin join) {
        graphicsContext.setLineJoin(join);
    }

    public StrokeLineJoin getLineJoin() {
        return graphicsContext.getLineJoin();
    }

    public void setMiterLimit(double ml) {
        graphicsContext.setMiterLimit(ml);
    }

    public double getMiterLimit() {
        return graphicsContext.getMiterLimit();
    }

    public void setLineDashes(double... dashes) {
        graphicsContext.setLineDashes(dashes);
    }

    public double[] getLineDashes() {
        return graphicsContext.getLineDashes();
    }

    public void setLineDashOffset(double dashOffset) {
        graphicsContext.setLineDashOffset(dashOffset);
    }

    public double getLineDashOffset() {
        return graphicsContext.getLineDashOffset();
    }

    public void setFont(Font f) {
        graphicsContext.setFont(f);
    }

    public Font getFont() {
        return graphicsContext.getFont();
    }

    public void setFontSmoothingType(FontSmoothingType fontsmoothing) {
        graphicsContext.setFontSmoothingType(fontsmoothing);
    }

    public FontSmoothingType getFontSmoothingType() {
        return graphicsContext.getFontSmoothingType();
    }

    public void setTextAlign(TextAlignment align) {
        graphicsContext.setTextAlign(align);
    }

    public TextAlignment getTextAlign() {
        return graphicsContext.getTextAlign();
    }

    public void setTextBaseline(VPos baseline) {
        graphicsContext.setTextBaseline(baseline);
    }

    public VPos getTextBaseline() {
        return graphicsContext.getTextBaseline();
    }

    public void fillText(String text, double x, double y) {
        graphicsContext.fillText(text, x, y);
    }

    public void strokeText(String text, double x, double y) {
        graphicsContext.strokeText(text, x, y);
    }

    public void fillText(String text, double x, double y, double maxWidth) {
        graphicsContext.fillText(text, x, y, maxWidth);
    }

    public void strokeText(String text, double x, double y, double maxWidth) {
        graphicsContext.strokeText(text, x, y, maxWidth);
    }

    public void setFillRule(FillRule fillRule) {
        graphicsContext.setFillRule(fillRule);
    }

    public FillRule getFillRule() {
        return graphicsContext.getFillRule();
    }

    public void beginPath() {
        graphicsContext.beginPath();
    }

    public void moveTo(double x0, double y0) {
        graphicsContext.moveTo(x0, y0);
    }

    public void lineTo(double x1, double y1) {
        graphicsContext.lineTo(x1, y1);
    }

    public void quadraticCurveTo(double xc, double yc, double x1, double y1) {
        graphicsContext.quadraticCurveTo(xc, yc, x1, y1);
    }

    public void bezierCurveTo(double xc1, double yc1, double xc2, double yc2, double x1, double y1) {
        graphicsContext.bezierCurveTo(xc1, yc1, xc2, yc2, x1, y1);
    }

    public void arcTo(double x1, double y1, double x2, double y2, double radius) {
        graphicsContext.arcTo(x1, y1, x2, y2, radius);
    }

    public void arc(double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length) {
        graphicsContext.arc(centerX, centerY, radiusX, radiusY, startAngle, length);
    }

    public void rect(double x, double y, double w, double h) {
        graphicsContext.rect(x, y, w, h);
    }

    public void appendSVGPath(String svgpath) {
        graphicsContext.appendSVGPath(svgpath);
    }

    public void closePath() {
        graphicsContext.closePath();
    }

    public void fill() {
        graphicsContext.fill();
    }

    public void stroke() {
        graphicsContext.stroke();
    }

    public void clip() {
        graphicsContext.clip();
    }

    public boolean isPointInPath(double x, double y) {
        return graphicsContext.isPointInPath(x, y);
    }

    public void clearRect(double x, double y, double w, double h) {
        graphicsContext.clearRect(x, y, w, h);
    }

    public void fillRect(double x, double y, double w, double h) {
        graphicsContext.fillRect(x, y, w, h);
    }

    public void strokeRect(double x, double y, double w, double h) {
        graphicsContext.strokeRect(x, y, w, h);
    }

    public void fillOval(double x, double y, double w, double h) {
        graphicsContext.fillOval(x, y, w, h);
    }

    public void strokeOval(double x, double y, double w, double h) {
        graphicsContext.strokeOval(x, y, w, h);
    }

    public void fillArc(double x, double y, double w, double h, double startAngle, double arcExtent, ArcType closure) {
        graphicsContext.fillArc(x, y, w, h, startAngle, arcExtent, closure);
    }

    public void strokeArc(double x, double y, double w, double h, double startAngle, double arcExtent, ArcType closure) {
        graphicsContext.strokeArc(x, y, w, h, startAngle, arcExtent, closure);
    }

    public void fillRoundRect(double x, double y, double w, double h, double arcWidth, double arcHeight) {
        graphicsContext.fillRoundRect(x, y, w, h, arcWidth, arcHeight);
    }

    public void strokeRoundRect(double x, double y, double w, double h, double arcWidth, double arcHeight) {
        graphicsContext.strokeRoundRect(x, y, w, h, arcWidth, arcHeight);
    }

    public void strokeLine(double x1, double y1, double x2, double y2) {
        graphicsContext.strokeLine(x1, y1, x2, y2);
    }

    public void fillPolygon(double[] xPoints, double[] yPoints, int nPoints) {
        graphicsContext.fillPolygon(xPoints, yPoints, nPoints);
    }

    public void strokePolygon(double[] xPoints, double[] yPoints, int nPoints) {
        graphicsContext.strokePolygon(xPoints, yPoints, nPoints);
    }

    public void strokePolyline(double[] xPoints, double[] yPoints, int nPoints) {
        graphicsContext.strokePolyline(xPoints, yPoints, nPoints);
    }

    public void drawImage(Image img, double x, double y) {
        graphicsContext.drawImage(img, x, y);
    }

    public void drawImage(Image img, double x, double y, double w, double h) {
        graphicsContext.drawImage(img, x, y, w, h);
    }

    public void drawImage(Image img, double sx, double sy, double sw, double sh, double dx, double dy, double dw, double dh) {
        graphicsContext.drawImage(img, sx, sy, sw, sh, dx, dy, dw, dh);
    }

    public PixelWriter getPixelWriter() {
        return graphicsContext.getPixelWriter();
    }

    public void setEffect(Effect e) {
        graphicsContext.setEffect(e);
    }

    public Effect getEffect(Effect e) {
        return graphicsContext.getEffect(e);
    }

    public void applyEffect(Effect e) {
        graphicsContext.applyEffect(e);
    }

    public double getWidth() {
        return getCanvas().getWidth();
    }

    public double getHeight() {
        return getCanvas().getHeight();
    }
    public void clear() {
        graphicsContext.clearRect(0, 0, getWidth(), getHeight());
    }

}
