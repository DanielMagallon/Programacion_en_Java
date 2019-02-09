package Unidad1;

import javax.media.j3d.BranchGroup;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class Java3D {

	public static void main(String[] args) {
		SimpleUniverse uni = new SimpleUniverse();
		BranchGroup grupos = new BranchGroup();
		grupos.addChild(new ColorCube(0.2));
		uni.getViewingPlatform().setNominalViewingTransform();
		uni.addBranchGraph(grupos);
		
	}
}

