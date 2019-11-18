package decaf.frontend.symbol;

import decaf.frontend.scope.ClassScope;
import decaf.frontend.scope.LambdaScope;
import decaf.frontend.tree.Pos;
import decaf.frontend.tree.Tree;
import decaf.frontend.type.FunType;

/**
 * Method symbol, representing a method definition.
 */
public final class LambdaSymbol extends Symbol {

    public final FunType type;

    /**
     * Associated formal scope of the method parameters.
     */
    public final LambdaScope scope;

    public final Tree.Modifiers modifiers;

    public final ClassSymbol owner;

    public LambdaSymbol(String name, FunType type, LambdaScope scope, Pos pos, Tree.Modifiers modifiers,
                        ClassSymbol owner) {
        super(name, type, pos);
        this.type = type;
        this.scope = scope;
        this.modifiers = modifiers;
        this.owner = owner;
        scope.setOwner(this);
    }

    @Override
    public ClassScope domain() {
        return (ClassScope) definedIn;
    }

    @Override
    public boolean isLambdaSymbol() {
        return true;
    }

    @Override
    protected String str() {
        var modStr = modifiers.toString();
        if (!modStr.isEmpty()) modStr += " ";
        return modStr + String.format("function %s : %s", name, type);
    }

    /**
     * Is it a main function?
     *
     * @return true/false
     */
    public boolean isMain() {
        return main;
    }

    /**
     * Set as main function, by {@link decaf.frontend.typecheck.Namer}.
     */
    public void setMain() {
        this.main = true;
    }

    public boolean isStatic() {
        return modifiers.isStatic();
    }

    public boolean isAbstract() {
        return modifiers.isAbstract();
    }

    private boolean main = false;
}
