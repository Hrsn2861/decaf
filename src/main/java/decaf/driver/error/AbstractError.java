package decaf.driver.error;

import decaf.frontend.tree.Pos;

/**
 * example：incompatible argument 3: int given, bool expected<br>
 * 3表示发生错误的是第三个参数<br>
 * PA2
 */
public class AbstractError extends DecafError {

    private String classname;

    public AbstractError(Pos pos, String classname) {
        super(pos);
        this.classname = classname;
    }

    @Override
    protected String getErrMsg() {
        return "\'" + classname + "\'" + " is not abstract and does not override all abstract methods";
    }

}
