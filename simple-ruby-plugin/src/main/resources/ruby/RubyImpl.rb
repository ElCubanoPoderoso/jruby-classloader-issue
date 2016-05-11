'use java'
java_import com.ruby.plugin.interfaces.RubyInterface

class RubyImpl
    include RubyInterface

    def initialize(stringInput)
        @stringInput = stringInput
    end

    def doSomething()
        puts @stringInput
    end
end
