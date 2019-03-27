require "./lib/version"

Gem::Specification.new do |spec|
  spec.name = "dsa"
  spec.version = Dsa::VERSION
  spec.authors = ["Evgeny Mironenko"]
  spec.email = ["miron4dev@gmail.com"]

  spec.summary = "Data Structures and Algorithms"
  spec.homepage = "https://github.com/miron4dev/data-structures-and-algorithms/ruby"
  spec.license = "MIT"

  # Prevent pushing this gem to RubyGems.org. To allow pushes either set the 'allowed_push_host'
  # to allow pushing to a single host or delete this section to allow pushing to any host.
  if spec.respond_to?(:metadata)
    spec.metadata["allowed_push_host"] = "TODO: Set to 'http://mygemserver.com'"

    spec.metadata["homepage_uri"] = spec.homepage
    spec.metadata["source_code_uri"] = "TODO: Put your gem's public repo URL here."
    spec.metadata["changelog_uri"] = "TODO: Put your gem's CHANGELOG.md URL here."
  else
    raise "RubyGems 2.0 or newer is required to protect against " \
      "public gem pushes."
  end

  spec.require_paths = ["lib"]
end
