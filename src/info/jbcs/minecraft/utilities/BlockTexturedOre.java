package info.jbcs.minecraft.utilities;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockTexturedOre extends Block {
	int		currentPass;
	Block	base;
	Icon	icon;
	String	iconFile;

	public BlockTexturedOre(int id, Material mat, Block base) {
		super(id, mat);

		this.base = base;
	}

	public BlockTexturedOre(int id, Material mat, String iconFile) {
		super(id, mat);

		this.iconFile=iconFile;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return BlockTexturedOreRenderer.id;
	}

	@Override
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public boolean canRenderInPass(int pass) {
		currentPass = pass;

		return pass == 1 || pass == 0;
	}
	
	@Override
	public void registerIcons(IconRegister register) {
		if(iconFile!=null)
			icon=register.registerIcon(iconFile);
	}

}
