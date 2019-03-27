module Algorithms::Leetcode::String

  class Anagram

    OFFSET = 'a'.ord

    def anagram?(str1, str2)
      return false if str1.length != str2.length

      temp = Array.new(26, 0)

      str1.each_byte {|c| temp[c - OFFSET] = temp[c - OFFSET] + 1}
      str2.each_byte {|c| temp[c - OFFSET] = temp[c - OFFSET] - 1}

      return temp.all? {|it| it == 0}
    end
  end
end

