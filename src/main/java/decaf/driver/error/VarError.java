package decaf.driver.error;

import decaf.frontend.tree.Pos;

/**
 * example：unterminated string constant: "this is str"<br>
 * PA1
 */
public class VarError extends DecafError {

    private String str;

    public VarError(Pos pos, String str) {
        super(pos);
        this.str = str;
    }

    @Override
    protected String getErrMsg() {
        return "cannot declare identifier \'" + str + "\' as void type";
    }

}
