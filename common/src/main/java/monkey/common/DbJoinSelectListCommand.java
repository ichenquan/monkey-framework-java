package monkey.common;

import java.util.List;

public interface DbJoinSelectListCommand<Record, Parameter> {

    List<Record> execute(Parameter parameter);
}
