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
        glScaled(3.3,Specification.ROOF_DEPTH,1);
        Materials.setMaterialRoof();
        new Cylinder().draw((float) Specification.ROOF_HEIGHT,
                (float) Specification.ROOF_HEIGHT, (float) Specification.ROOF_DEPTH, 20, 1);
        glRotated(180,1,0,0);
        new Disk().draw(0, (float) Specification.ROOF_HEIGHT, 20, 1);

        glRotated(-180,1,0,0);
        glTranslated(0,0,Specification.ROOF_DEPTH);
        new Disk().draw(0, (float) Specification.ROOF_HEIGHT, 20, 1);
        glTranslated(0,0,0.01);
        glPopMatrix();
    }

    @Override
    public void init() {

    }
}
