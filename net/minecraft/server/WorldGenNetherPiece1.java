package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class WorldGenNetherPiece1 extends WorldGenNetherPiece {

    public WorldGenNetherPiece1(int i, Random random, StructureBoundingBox structureboundingbox, int j) {
        super(i);
        this.f = j;
        this.e = structureboundingbox;
    }

    protected WorldGenNetherPiece1(Random random, int i, int j) {
        super(0);
        this.f = random.nextInt(4);
        switch (this.f) {
        case 0:
        case 2:
            this.e = new StructureBoundingBox(i, 64, j, i + 19 - 1, 73, j + 19 - 1);
            break;

        default:
            this.e = new StructureBoundingBox(i, 64, j, i + 19 - 1, 73, j + 19 - 1);
        }
    }

    public void a(StructurePiece structurepiece, List list, Random random) {
        this.a((WorldGenNetherPiece15) structurepiece, list, random, 8, 3, false);
        this.b((WorldGenNetherPiece15) structurepiece, list, random, 3, 8, false);
        this.c((WorldGenNetherPiece15) structurepiece, list, random, 3, 8, false);
    }

    public static WorldGenNetherPiece1 a(List list, Random random, int i, int j, int k, int l, int i1) {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.a(i, j, k, -8, -3, 0, 19, 10, 19, l);

        return a(structureboundingbox) && StructurePiece.a(list, structureboundingbox) == null ? new WorldGenNetherPiece1(i1, random, structureboundingbox, l) : null;
    }

    public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
        this.a(world, structureboundingbox, 7, 3, 0, 11, 4, 18, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);
        this.a(world, structureboundingbox, 0, 3, 7, 18, 4, 11, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);
        this.a(world, structureboundingbox, 8, 5, 0, 10, 7, 18, 0, 0, false);
        this.a(world, structureboundingbox, 0, 5, 8, 18, 7, 10, 0, 0, false);
        this.a(world, structureboundingbox, 7, 5, 0, 7, 5, 7, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);
        this.a(world, structureboundingbox, 7, 5, 11, 7, 5, 18, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);
        this.a(world, structureboundingbox, 11, 5, 0, 11, 5, 7, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);
        this.a(world, structureboundingbox, 11, 5, 11, 11, 5, 18, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);
        this.a(world, structureboundingbox, 0, 5, 7, 7, 5, 7, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);
        this.a(world, structureboundingbox, 11, 5, 7, 18, 5, 7, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);
        this.a(world, structureboundingbox, 0, 5, 11, 7, 5, 11, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);
        this.a(world, structureboundingbox, 11, 5, 11, 18, 5, 11, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);
        this.a(world, structureboundingbox, 7, 2, 0, 11, 2, 5, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);
        this.a(world, structureboundingbox, 7, 2, 13, 11, 2, 18, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);
        this.a(world, structureboundingbox, 7, 0, 0, 11, 1, 3, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);
        this.a(world, structureboundingbox, 7, 0, 15, 11, 1, 18, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);

        int i;
        int j;

        for (i = 7; i <= 11; ++i) {
            for (j = 0; j <= 2; ++j) {
                this.b(world, Block.NETHER_BRICK.id, 0, i, -1, j, structureboundingbox);
                this.b(world, Block.NETHER_BRICK.id, 0, i, -1, 18 - j, structureboundingbox);
            }
        }

        this.a(world, structureboundingbox, 0, 2, 7, 5, 2, 11, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);
        this.a(world, structureboundingbox, 13, 2, 7, 18, 2, 11, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);
        this.a(world, structureboundingbox, 0, 0, 7, 3, 1, 11, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);
        this.a(world, structureboundingbox, 15, 0, 7, 18, 1, 11, Block.NETHER_BRICK.id, Block.NETHER_BRICK.id, false);

        for (i = 0; i <= 2; ++i) {
            for (j = 7; j <= 11; ++j) {
                this.b(world, Block.NETHER_BRICK.id, 0, i, -1, j, structureboundingbox);
                this.b(world, Block.NETHER_BRICK.id, 0, 18 - i, -1, j, structureboundingbox);
            }
        }

        return true;
    }
}
