package edu.cg.models.Locomotive;

import edu.cg.models.IRenderable;
import edu.cg.util.glu.Cylinder;
import edu.cg.util.glu.Disk;

import static org.lwjgl.opengl.GL11.*;

/***
 * A 3D roof model renderer.
 * The roof is modeled using a cylinder bounded by disks that undergo a non-uniform scaling.
 */
public class Roof implements IRenderable {

    @Override
    public void render() {
        glPushMatrix();
        // Done(7): Render the locomotive back body roof
        glScalef((float) (Specification.ROOF_WIDTH * 1.25), (float) (Specification.ROOF_HEIGHT * 2 ) , 1);
        Materials.setMaterialRoof();
        new Cylinder().draw((float) (Specification.ROOF_WIDTH),
                (float) (Specification.ROOF_WIDTH- Specification.EPS), (float) Specification.ROOF_DEPTH, 20, 1);
        draw_edges();
        glRotated(180, 1, 0, 0);
        glTranslatef(0, 0, (float) -Specification.ROOF_DEPTH);
        draw_edges();
        glPopMatrix();
    }

    public void draw_edges(){
        glPushMatrix();
        glRotated(180, 0, 1, 0);
        Materials.setMaterialRoof();
        new Disk().draw(0, (float) Specification.ROOF_WIDTH, 20, 1);
        glPopMatrix();
    }

    @Override
    public void init() {

    }
}
