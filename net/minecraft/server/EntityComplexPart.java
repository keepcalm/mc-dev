package net.minecraft.server;

public class EntityComplexPart extends Entity {

    public final IComplex owner;
    public final String b;

    public EntityComplexPart(IComplex icomplex, String s, float f, float f1) {
        super(icomplex.d());
        this.a(f, f1);
        this.owner = icomplex;
        this.b = s;
    }

    protected void a() {}

    protected void a(NBTTagCompound nbttagcompound) {}

    protected void b(NBTTagCompound nbttagcompound) {}

    public boolean L() {
        return true;
    }

    public boolean damageEntity(DamageSource damagesource, int i) {
        return this.isInvulnerable() ? false : this.owner.a(this, damagesource, i);
    }

    public boolean i(Entity entity) {
        return this == entity || this.owner == entity;
    }
}
