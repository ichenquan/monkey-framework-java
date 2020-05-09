package monkey.common;

import java.util.List;


public interface DbJoinSelectPageCommand<Record, Parameter> {

    List<Record> execute(Parameter parameter);
}