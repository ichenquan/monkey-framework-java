package monkey.common;

public interface DbJoinSelectCountCommand<Parameter> {
    
    Integer execute(Parameter parameter);
}
